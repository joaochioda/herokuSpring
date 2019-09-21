package com.example.heroku2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    private Long id;
    private String name;
    private String sobrenome;
    private String email;
    private String rg;
    private Double pontos;
    private String phone;
    @ManyToMany
    private List<Essencia> essencia;

    public Person() {

    }

    public Person(String name, String sobrenome, String email, String rg, Double pontos, String phone, List<Essencia> essencia) {
        this.name = name;
        this.sobrenome = sobrenome;
        this.email = email;
        this.rg = rg;
        this.pontos = pontos;
        this.phone = phone;
        this.essencia = essencia;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public List<Essencia> getEssencia() {
        return essencia;
    }

    public void setEssencia(List<Essencia> essencia) {
        this.essencia = essencia;
    }

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
