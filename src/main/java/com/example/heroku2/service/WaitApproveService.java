package com.example.heroku2.service;

import com.example.heroku2.essenciaStatus;
import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Person;
import com.example.heroku2.model.WaitApprove;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.PersonRepository;
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


    public  List<WaitApprove> getwaitApproveService() {
        List<WaitApprove> waitApprove = new ArrayList<>();
        waitApproveRepository.findAll().forEach(waitApprove::add);
        return waitApprove;
    }

    public WaitApprove addWaitApprove(WaitApprove waitApprove) {
        return waitApproveRepository.save(waitApprove);
    }

    public WaitApprove addApprovePerson (Long id, Person person) {
        Optional<WaitApprove> waitApprove = waitApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(person.getId());
        if(waitApprove.isPresent() && personFind.isPresent()){

            List<Person> people = waitApprove.get().getPeoplePro();
            people.add(personFind.get());
            if(people.size() >3) {
            Optional<Essencia> essencia = essenciaRepository.findById(waitApprove.get().getEssencia().getId());
            if(essencia.isPresent()){
                essencia.get().setStatus(essenciaStatus.CREATED);
                waitApproveRepository.delete(waitApprove.get());
            }

            }
            else {
                waitApprove.get().setPeoplePro(people);
                return waitApproveRepository.save(waitApprove.get());

            }

        }

        return waitApprove.get();
    }

    public WaitApprove addDenyPerson (Long id, Person person) {
        Optional<WaitApprove> waitApprove = waitApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(person.getId());
        if(waitApprove.isPresent() && personFind.isPresent()){

            List<Person> people = waitApprove.get().getPeopleAgainst();
            people.add(personFind.get());
            if(people.size() >3) {
                Optional<Essencia> essencia = essenciaRepository.findById(waitApprove.get().getEssencia().getId());
                if(essencia.isPresent()){
                    essencia.get().setStatus(essenciaStatus.DELETED);
                    waitApproveRepository.delete(waitApprove.get());
                }

            }
            else {
                waitApprove.get().setPeopleAgainst(people);
                return waitApproveRepository.save(waitApprove.get());

            }
        }
        return waitApprove.get();
    }
}
