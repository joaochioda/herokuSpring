package com.example.heroku2.resource;

import com.example.heroku2.model.Person;
import com.example.heroku2.repository.PersonRepository;
import com.example.heroku2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PeopleResource {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;



//    @PutMapping("/person/{id}")
//    public ResponseEntity<?> saveResource(@RequestBody Person person,@PathVariable("id") Long id) {
//        personService.updatePerson(person,id);
//        return ResponseEntity.ok("resource saved");
//    }



    @RequestMapping(value = "/person", method =  RequestMethod.POST)
        public Person addPerson(@RequestBody Person person){
           return personService.addPerson(person);
        }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getPeron(){
        return personService.getPerson();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PATCH)
    public void getLanche(@PathVariable Long id){

        personService.updatePerson(id);
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public void getPeopleId(@PathVariable(value = "id") long id) {
        System.out.println("oi");
    }

}
