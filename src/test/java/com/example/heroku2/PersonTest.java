package com.example.heroku2;


import com.example.heroku2.repository.Contatos;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonTest {

    @Autowired
    private Contatos personRepositoryRepository;

    @Test
    public void addPerson() {
//        Person person = new Person("joao","guilherme","a@a.com","454.52.268-x",99.0,"32033765",null);
//        this.personRepositoryRepository.save(person);
//        Assertions.assertThat(person.getName()).isEqualTo("jao");
    }
}
