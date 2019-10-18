package com.example.heroku2.model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String marca;
    private String image;


    public Marca (String marca) {
        this.marca = marca;
    }

    public Marca(String marca, String image) {
        this.marca = marca;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
