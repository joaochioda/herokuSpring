package com.example.heroku2.model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String marca;


    public Marca (String marca) {
        this.marca = marca;
    }

    public Marca() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
