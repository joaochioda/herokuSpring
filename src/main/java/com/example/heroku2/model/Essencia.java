package com.example.heroku2.model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)

public class Essencia {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    private Long id;
    private String essencia;
    private String marca;
    private String gosto;
    private Double repoutacao;
    private String imagem;

    public Essencia(Long id, String essencia, String marca, String gosto, Double repoutacao, String imagem) {
        this.id = id;
        this.essencia = essencia;
        this.marca = marca;
        this.gosto = gosto;
        this.repoutacao = repoutacao;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEssencia() {
        return essencia;
    }

    public void setEssencia(String essencia) {
        this.essencia = essencia;
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

    public Double getRepoutacao() {
        return repoutacao;
    }

    public void setRepoutacao(Double repoutacao) {
        this.repoutacao = repoutacao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

