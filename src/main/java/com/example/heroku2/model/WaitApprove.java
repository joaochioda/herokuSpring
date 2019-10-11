package com.example.heroku2.model;


import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class WaitApprove {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    @ManyToOne
    private Essencia essencia;
    @ManyToOne
    private Person owner;
    @ManyToMany
    private List<Person> peoplePro;
    @ManyToMany
    private List<Person> peopleAgainst;

    public WaitApprove(Long id, Essencia essencia, Person owner, List<Person> peoplePro, List<Person> peopleAgainst) {
        this.id = id;
        this.essencia = essencia;
        this.owner = owner;
        this.peoplePro = peoplePro;
        this.peopleAgainst = peopleAgainst;
    }

    public WaitApprove(Long id, Essencia essencia, Person owner) {
        this.id = id;
        this.essencia = essencia;
        this.owner = owner;
    }

    public WaitApprove() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Essencia getEssencia() {
        return essencia;
    }

    public void setEssencia(Essencia essencia) {
        this.essencia = essencia;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<Person> getPeoplePro() {
        return peoplePro;
    }

    public void setPeoplePro(List<Person> peoplePro) {
        this.peoplePro = peoplePro;
    }

    public List<Person> getPeopleAgainst() {
        return peopleAgainst;
    }

    public void setPeopleAgainst(List<Person> peopleAgainst) {
        this.peopleAgainst = peopleAgainst;
    }
}
