package com.example.heroku2.service;

import com.example.heroku2.model.Marca;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca addMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> getAllMarcas() {
        List<Marca> marcas = new ArrayList<>();
        marcaRepository.findAll().forEach(marcas::add);
        return marcas;
    }
}
