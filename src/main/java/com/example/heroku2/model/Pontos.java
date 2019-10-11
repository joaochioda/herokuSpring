package com.example.heroku2.model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Pontos {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private Long essenciaId;
    private Long pontos;

    public Pontos(Long id, Long essenciaId, Long pontos) {
        this.id = id;
        this.essenciaId = essenciaId;
        this.pontos = pontos;
    }

    public Pontos(Long essenciaId, Long pontos) {
        this.essenciaId = essenciaId;
        this.pontos = pontos;
    }

    public Pontos() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEssenciaId() {
        return essenciaId;
    }

    public void setEssenciaId(Long essenciaId) {
        this.essenciaId = essenciaId;
    }

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }
}
