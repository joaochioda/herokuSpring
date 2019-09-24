package com.example.heroku2.service;

import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Person;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EssenciaRepository essenciaRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }


    public  List<Person> getPerson() {
        List<Person> person = new ArrayList<>();
        personRepository.findAll().forEach(person::add);
        return person;
    }


    public Person removeEssencia (Essencia essencia, Long id) {
        Optional<Essencia> essenciaOpt = essenciaRepository.findById(essencia.getId());
        Optional<Person> personOpt = personRepository.findById(id);
        if (essenciaOpt.isPresent() && personOpt.isPresent()){
            Essencia essencia1 = essenciaOpt.get();
            Person person1 = personOpt.get();
            List<Essencia> listaEssencia = new ArrayList<>();
            person1.getEssencias().forEach(c-> {
                if (c.getId() != essencia1.getId()){
                    listaEssencia.add(c);
                }
            });

            person1.setEssencias(listaEssencia);
            return personRepository.save(person1);
        }
        return null;
    }

    public List<Essencia> getPersonEssencia (Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return person.get().getEssencias();
        }

        return null;
    }

    public Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            return person.get();
        }

        return null;
    }

    public Person addEssencia(Essencia essencia, Long id) {
        Optional<Essencia> essenciaNova = essenciaRepository.findById(essencia.getId());
        Optional<Person> person = personRepository.findById(id);
        if(essenciaNova.isPresent()){
            Essencia ess = essenciaNova.get();
            Person perss = person.get();

            List<Essencia> listaEssencia = new ArrayList<>();

            Essencia batata = new Essencia();

            perss.getEssencias().stream().forEach(c-> {
                    batata.setId(c.getId());
                    batata.setGosto(c.getGosto());
                    batata.setReputacao(c.getReputacao());
                    batata.setSabor(c.getSabor());
                    batata.setMarca(c.getMarca());
                    batata.setComentario(c.getComentario());
                    listaEssencia.add(batata);
                    }
                    );

            listaEssencia.add(ess);

            perss.setEssencias(listaEssencia);

            return personRepository.save(perss);
        }
        else {
            return null;
        }
    }
}
