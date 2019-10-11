package com.example.heroku2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String name;
    private String estado;
    private String cidade;
    private String token;
    private String email;

    @ManyToMany
    private List<Pontos> pontos;

    @ManyToMany
    private List<Essencia> essencias;

    public Person(Long id, String name, String estado, String cidade, String token, String email, List<Essencia> essencias, List<Pontos> pontos) {
        this.id = id;
        this.name = name;
        this.estado = estado;
        this.cidade = cidade;
        this.token = token;
        this.email = email;
        this.essencias = essencias;
        this.pontos = pontos;
    }

    public Person(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public List<Pontos> getPontos() {
        return pontos;
    }

    public void setPontos(List<Pontos> pontos) {
        this.pontos = pontos;
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


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {

}

    public Person(Long id) {
        this.id = id;
    }

    public void setEssencias(List<Essencia> essencias) {
        this.essencias = essencias;
    }
}
