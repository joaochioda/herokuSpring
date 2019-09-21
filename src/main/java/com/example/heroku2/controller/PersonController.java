package com.example.heroku2.controller;

import com.example.heroku2.model.Person;
import com.example.heroku2.repository.PersonRepository;
import com.example.heroku2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST, value= "/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
}
