package com.example.heroku2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contato {
    @Id
    private Long id;
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
