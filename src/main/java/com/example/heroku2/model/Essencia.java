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
    private String gosto;
    private String sabor;
    private String comentario;
    private Long reputacao;
    private essenciaStatus status;
    ;

    @ManyToMany
    private List<Marca> marca;

    public Essencia(String gosto, String sabor, Long reputacao,String comentario, List<Marca> marca) {
        this.comentario = comentario;
        this.gosto = gosto;
        this.sabor = sabor;
        this.reputacao = reputacao;
        this.marca = marca;
    }

    public essenciaStatus getStatus() {
        return status;
    }

    public void setStatus(essenciaStatus status) {
        this.status = status;
    }

    public Essencia() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Marca> getMarca() {
        return marca;
    }

    public void setMarca(List<Marca> marca) {
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
