package com.example.heroku2.service;

import com.example.heroku2.controller.BodyWaitApprove;
import com.example.heroku2.essenciaStatus;
import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Person;
import com.example.heroku2.model.Pontos;
import com.example.heroku2.model.WaitApprove;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.PersonRepository;
import com.example.heroku2.repository.PontosRepository;
import com.example.heroku2.repository.WaitApproveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaitApproveService {
    @Autowired
    private WaitApproveRepository waitApproveRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EssenciaRepository essenciaRepository;

    @Autowired
    private PontosRepository pontosRepository;

    public  List<WaitApprove> getwaitApproveService() {
        List<WaitApprove> waitApprove = new ArrayList<>();
        waitApproveRepository.findAll().forEach(waitApprove::add);
        return waitApprove;
    }

    public WaitApprove addWaitApprove(WaitApprove waitApprove) {
        waitApprove.setStatus(essenciaStatus.WAITTING);
        
        return waitApproveRepository.save(waitApprove);
    }

    public WaitApprove addApprovePerson (Long id, Person person) {
        Optional<WaitApprove> waitApprove = waitApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(person.getId());
        if(waitApprove.isPresent() && personFind.isPresent()){
            if(waitApprove.get().getOwner().getId() != person.getId()) {


                List<Person> people = waitApprove.get().getPeoplePro();

                if (checkAlreadyVoted(people, person) == true ){
                    return waitApprove.get();
                } else {
                    people.add(personFind.get());
                    if (people.size() > 2) {
                        Optional<Essencia> essencia = essenciaRepository.findById(waitApprove.get().getEssencia().getId());
                        if (essencia.isPresent()) {
                            givePoints(essencia.get().getId(), 3, waitApprove.get().getOwner());
                            people.forEach(c -> givePoints(essencia.get().getId(), 1, c));

                            essencia.get().setStatus(essenciaStatus.CREATED);
                            waitApproveRepository.delete(waitApprove.get());
                        }

                    } else {
                        waitApprove.get().setPeoplePro(people);
                        return waitApproveRepository.save(waitApprove.get());

                    }
                }
            }

        }

        return waitApprove.get();
    }

    public boolean checkAlreadyVoted(List<Person> people, Person person) {
        for(Person o : people) {
            if(o != null && o.getId() == person.getId()) {
                return true;
            }
        }
        return false;
    }



    public void givePoints(long essenciaId, long pontos, Person person) {

        Pontos returnPontos = pontosRepository.save(new Pontos(essenciaId, pontos));

        List<Pontos> pontosList = person.getPontos();
        pontosList.add(returnPontos);
        personRepository.save(person);
    }

    public WaitApprove addDenyPerson (Long id, BodyWaitApprove bodyWaitApprove) {
        Optional<WaitApprove> waitApprove = waitApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(bodyWaitApprove.getPerson().getId());
        if(waitApprove.isPresent() && personFind.isPresent()) {
            if (waitApprove.get().getOwner().getId() != bodyWaitApprove.getPerson().getId()) {
                String allMessage = (waitApprove.get().getMessage() == null) ? "" : waitApprove.get().getMessage();
                String newMessage = bodyWaitApprove.getString();
                allMessage = allMessage.concat(newMessage + System.lineSeparator());
                List<Person> people = waitApprove.get().getPeopleAgainst();

                if (checkAlreadyVoted(people, bodyWaitApprove.getPerson()) == true ){
                    return waitApprove.get();
                } else {
                    people.add(personFind.get());
                    if (people.size() > 3) {
                        Optional<Essencia> essencia = essenciaRepository.findById(waitApprove.get().getEssencia().getId());
                        if (essencia.isPresent()) {
                            essencia.get().setStatus(essenciaStatus.DELETED);
                            waitApprove.get().setStatus(essenciaStatus.DELETED);
                            return waitApproveRepository.save(waitApprove.get());
                        }

                    } else {
                        waitApprove.get().setPeopleAgainst(people);
                        waitApprove.get().setMessage(allMessage);
                        return waitApproveRepository.save(waitApprove.get());

                    }
                }
            }
        }
        return waitApprove.get();
    }
}
