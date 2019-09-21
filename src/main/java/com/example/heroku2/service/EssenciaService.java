package com.example.heroku2.service;

import com.example.heroku2.model.Essencia;
import com.example.heroku2.repository.EssenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EssenciaService {

    @Autowired
    private EssenciaRepository essenciaRepository;

    public Essencia addEssencia(Essencia essencia) {
        return essenciaRepository.save(essencia);
    }
}
