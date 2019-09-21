package com.example.heroku2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String name;
    private String phone;
    @ManyToMany
    private List<Essencia> essencias;

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

    public List<Essencia> getEssencias() {
        return essencias;
    }

    public Person(Long id, String name, String phone, List<Essencia> essencias) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.essencias = essencias;
    }

    public void setEssencias(List<Essencia> essencias) {
        this.essencias = essencias;
    }
}
