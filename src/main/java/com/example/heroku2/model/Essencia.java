package com.example.heroku2.model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)

public class Essencia {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String marca;
    private String gosto;
    private String sabor;
    private String comentario;
    private Long reputacao;

    public Essencia(String marca, String gosto, String sabor, Long reputacao,String comentario) {
        this.marca = marca;
        this.comentario = comentario;
        this.gosto = gosto;
        this.sabor = sabor;
        this.reputacao = reputacao;
    }

    public Essencia() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGosto() {
        return gosto;
    }

    public void setGosto(String gosto) {
        this.gosto = gosto;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Long getReputacao() {
        return reputacao;
    }

    public void setReputacao(Long reputacao) {
        this.reputacao = reputacao;
    }
}
