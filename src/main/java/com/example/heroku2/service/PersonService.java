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
