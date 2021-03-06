package com.example.heroku2.service;

import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Person;
import com.example.heroku2.model.Pontos;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EssenciaRepository essenciaRepository;

    public long getPontos (Long id) {
        long totalPontos=0;
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            List<Pontos> pontos = person.get().getPontos();
            for(Pontos p : pontos) {
                totalPontos = p.getPontos() + totalPontos;
            }
        }
        return totalPontos;
    }
    
    public Boolean addPerson(Person person){
        try {
            personRepository.save(person);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Person findMe(Person person) {
        long personId = 0;
        String name="";
        for(Person c : personRepository.findAll()){
            if (c.getToken().contentEquals(person.getToken()) && c.getEmail().contentEquals(person.getEmail())) {
                personId = c.getId();
                name = c.getName();
            }

        }
        return new Person(personId,name,null,null,null,null,null,null);
    }

    public Boolean getIsRegistered(Person person) {
        Boolean find=false;
        for (Person c : personRepository.findAll()) {
            if (c.getToken().contentEquals(person.getToken()) && c.getEmail().contentEquals(person.getEmail())) {
                find = true;
                break;
            }
        }
        return find;
    }

    public  List<Person> getPerson() {
        List<Person> person = new ArrayList<>();
        personRepository.findAll().forEach(person::add);
        return person;
    }

    public Boolean removePerson (Long id) {
        Optional<Person> personOpt = personRepository.findById(id);
        if (personOpt.isPresent()) {
            personRepository.delete(personOpt.get());
            return true;
        }
        else {
            return false;
        }
    }

    public Person removeEssencia (Long ed, Long id) {
        Optional<Essencia> essenciaOpt = essenciaRepository.findById(ed);
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


            if(person.get().getEssencias().contains(essenciaNova.get())){
               return null;
            };

            Essencia ess = essenciaNova.get();
            Person perss = person.get();


            List<Essencia> listaEssencia = new ArrayList<>();

            perss.getEssencias().stream().forEach(c-> {
                Essencia batata = new Essencia();
                batata.setId(c.getId());
                    batata.setGosto(c.getGosto());
                    batata.setNome(c.getNome());
                    batata.setProposta(c.getProposta());
                    batata.setReputacao(c.getReputacao());
                    batata.setSabor(c.getSabor());
                    batata.setMarca(c.getMarca());
                    batata.setComentario(c.getComentario());
                    batata.setMessage(c.getMessage());
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
