package com.example.heroku2.service;

import com.example.heroku2.model.Person;
import com.example.heroku2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person updatePerson(Long id) {

        return null;

    }
}
