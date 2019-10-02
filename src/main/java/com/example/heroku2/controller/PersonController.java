package com.example.heroku2.controller;

import com.example.heroku2.model.Essencia;
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

    @RequestMapping(method = RequestMethod.POST, value="/person/{id}/essencia")
    public Person addEssencia(@RequestBody Essencia essencia, @PathVariable Long id) {
        return personService.addEssencia(essencia, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/person/{id}/essencia")
    public Person removeEssencia(@RequestBody Essencia essencia, @PathVariable Long id) {
        return personService.removeEssencia(essencia, id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/person/{id}/essencia")
    public List<Essencia> getPersonEssencia(@PathVariable Long id) {
        return personService.getPersonEssencia(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/person/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/person")
    public List<Person> getPerson() {
       return personService.getPerson();
    }

    @RequestMapping(method = RequestMethod.GET, value="/registered")
    public Boolean getIsRegistered(@RequestBody Person person) {
        return personService.getIsRegistered(person);
    }
}
