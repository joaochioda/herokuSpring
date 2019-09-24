package com.example.heroku2.service;

import com.example.heroku2.model.Essencia;
import com.example.heroku2.repository.EssenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EssenciaService {

    @Autowired
    private EssenciaRepository essenciaRepository;

    public Essencia addEssencia(Essencia essencia) {
        return essenciaRepository.save(essencia);
    }

    public Essencia getEssenciaById(Long id) {
        Optional<Essencia> essencia = essenciaRepository.findById(id);
        if(essencia.isPresent()){
            return essencia.get();
        }
        return null;
    }

    public List<Essencia> getAllEssencia() {
        List<Essencia> essencias = new ArrayList<>();
        essenciaRepository.findAll().forEach(essencias::add);
        return essencias;
    }
}
