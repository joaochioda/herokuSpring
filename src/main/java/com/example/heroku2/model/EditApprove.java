package com.example.heroku2.model;


import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class EditApprove {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Essencia essenciaAntiga;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Essencia essenciaNova;
    @ManyToOne
    private Person owner;
    @ManyToMany
    private List<Person> peoplePro;
    @ManyToMany
    private List<Person> peopleAgainst;


    public EditApprove(Essencia essenciaAntiga, Essencia essenciaNova, Person owner, List<Person> peoplePro, List<Person> peopleAgainst) {
        this.essenciaAntiga = essenciaAntiga;
        this.essenciaNova = essenciaNova;
        this.owner = owner;
        this.peoplePro = peoplePro;
        this.peopleAgainst = peopleAgainst;
    }

    public EditApprove(Essencia essenciaAntiga, Essencia essenciaNova, Person owner) {
        this.essenciaAntiga = essenciaAntiga;
        this.essenciaNova = essenciaNova;
        this.owner = owner;
    }

    public EditApprove() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Essencia getEssenciaAntiga() {
        return essenciaAntiga;
    }

    public void setEssenciaAntiga(Essencia essenciaAntiga) {
        this.essenciaAntiga = essenciaAntiga;
    }

    public Essencia getEssenciaNova() {
        return essenciaNova;
    }

    public void setEssenciaNova(Essencia essenciaNova) {
        this.essenciaNova = essenciaNova;
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
