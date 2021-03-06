package com.example.heroku2.service;

import com.example.heroku2.essenciaStatus;
import com.example.heroku2.model.EditApprove;
import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Person;
import com.example.heroku2.model.Pontos;
import com.example.heroku2.repository.EditApproveRepository;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.PersonRepository;
import com.example.heroku2.repository.PontosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditApproveService {
    @Autowired
    private EditApproveRepository editApproveRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EssenciaRepository essenciaRepository;

    @Autowired
    private PontosRepository pontosRepository;

    public EditApprove addEditApprove(EditApprove editApprove) {
        Essencia es = editApprove.getEssenciaNova();
        Essencia essencia = new Essencia(es.getNome(),es.getGosto(),es.getSabor(),es.getProposta(),es.getComentario(),
                es.getReputacao(),essenciaStatus.EDITING,es.getImage(),es.getMarca());
        Essencia newEssencia =   essenciaRepository.save(essencia);

        editApprove.setEssenciaNova(newEssencia);
        editApproveRepository.save(editApprove);

        return editApprove;
    }

    public List<EditApprove> getEditApprove() {
        List<EditApprove> editApprove = new ArrayList<>();
        editApproveRepository.findAll().forEach(editApprove::add);
        return editApprove;
    }

    public EditApprove addAproveEdit (Long id, Person person) {
        Optional<EditApprove> editApprove = editApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(person.getId());
        if(editApprove.isPresent() && personFind.isPresent()){
            if(editApprove.get().getOwner().getId() != person.getId()) {


                List<Person> people = editApprove.get().getPeoplePro();

                if (checkAlreadyVoted(people, person) == true ){
                    editApprove.get().getPeoplePro().remove(personFind.get());
                    editApproveRepository.save((editApprove.get()));
                    return editApprove.get();
                } else {
                    people.add(personFind.get());

                    if(people.size()>2) {
                        Optional<Essencia> essencia = essenciaRepository.findById(editApprove.get().getEssenciaNova().getId());
                        Optional<Essencia> essenciaVelha = essenciaRepository.findById(editApprove.get().getEssenciaAntiga().getId());
                        if (essencia.isPresent()) {
                            givePoints(essencia.get().getId(), 3, editApprove.get().getOwner());
                            people.forEach(c -> givePoints(essencia.get().getId(), 1, c));

                            essenciaVelha.get().setProposta(essencia.get().getProposta());
                            essenciaVelha.get().setNome(essencia.get().getNome());
                            essenciaVelha.get().setComentario(essencia.get().getComentario());
                            essenciaVelha.get().setSabor(essencia.get().getSabor());
                            essenciaVelha.get().setReputacao(essencia.get().getReputacao());
                            essenciaVelha.get().setGosto(essencia.get().getGosto());
                            essenciaVelha.get().setImage(essencia.get().getImage());

                            essenciaRepository.save(essenciaVelha.get());
                            editApproveRepository.delete(editApprove.get());
                            essenciaRepository.delete(essencia.get());
                        }

                    } else {
                        editApprove.get().setPeoplePro(people);
                        editApproveRepository.save(editApprove.get());
                    }

                }
                }
            }



        return editApprove.get();
    }

    public EditApprove addDenyEdit(Long id, Person person) {
        Optional<EditApprove> editApprove = editApproveRepository.findById(id);
        Optional<Person> personFind = personRepository.findById(person.getId());
        if(editApprove.isPresent() && personFind.isPresent()){
            if(editApprove.get().getOwner().getId() != person.getId()) {

                List<Person> people = editApprove.get().getPeopleAgainst();

                if (checkAlreadyVoted(people, person) == true ){
                    editApprove.get().getPeopleAgainst().remove(personFind.get());
                    editApproveRepository.save((editApprove.get()));
                    return editApprove.get();
                } else {
                    people.add(personFind.get());

                    if(people.size()>2) {
                        Optional<Essencia> essencia = essenciaRepository.findById(editApprove.get().getEssenciaNova().getId());
                        if (essencia.isPresent()) {
                            editApproveRepository.delete(editApprove.get());
                            essenciaRepository.delete(essencia.get());
                        }

                    } else {
                        editApprove.get().setPeopleAgainst(people);
                        editApproveRepository.save(editApprove.get());
                    }

                }
            }
        }



        return editApprove.get();
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

}
