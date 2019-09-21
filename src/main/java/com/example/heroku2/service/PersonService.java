package com.example.heroku2.service;

import com.example.heroku2.model.Person;
import com.example.heroku2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }
}
