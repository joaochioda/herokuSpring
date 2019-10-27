package com.example.heroku2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Person person;
    private String date;
    private String text;
    public Message() {

    }

    public Message(Person person, String text) {
        this.person = person;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
