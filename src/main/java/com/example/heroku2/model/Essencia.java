package com.example.heroku2.model;

import com.example.heroku2.essenciaStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)

public class Essencia {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String nome;
    private String gosto;
    private String sabor;
    private String proposta;
    private String comentario;
    private Long reputacao;
    private essenciaStatus status;
    private String image;
    @ManyToOne
    private Marca marca;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Essencia() {

    }

    public Essencia(String nome, Marca marca, String image) {
        this.nome = nome;
        this.marca = marca;
        this.image = image;

    }
    public Essencia(String gosto, String sabor, Long reputacao,String comentario, Marca marca, String nome, String proposta, String image) {
        this.comentario = comentario;
        this.nome = nome;
        this.proposta = proposta;
        this.gosto = gosto;
        this.sabor = sabor;
        this.reputacao = reputacao;
        this.marca = marca;
        this.image = image;
    }

    public essenciaStatus getStatus() {
        return status;
    }

    public void setStatus(essenciaStatus status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public Essencia(String gosto, String sabor, Long reputacao, String comentario, Marca marca, String image, String proposta, essenciaStatus status, String nome) {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
