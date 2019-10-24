package com.example.heroku2.model;

import com.example.heroku2.model.Person;

public class BodyWaitApprove {
    private Person person;
    private String string;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public BodyWaitApprove(Person person, String string) {
        this.person = person;
        this.string = string;
    }

    public BodyWaitApprove() {

    }
}
