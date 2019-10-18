package com.example.heroku2.model;

import java.util.List;

public class CadastrarTudo {
    private String marca;
    private String image;
    private List<Essencia> essencias;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Essencia> getEssencias() {
        return essencias;
    }

    public void setEssencias(List<Essencia> essencias) {
        this.essencias = essencias;
    }
}
