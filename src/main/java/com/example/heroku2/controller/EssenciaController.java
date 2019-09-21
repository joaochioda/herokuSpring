package com.example.heroku2.controller;

import com.example.heroku2.model.Essencia;
import com.example.heroku2.service.EssenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EssenciaController {

    @Autowired
    private EssenciaService essenciaService;

    @RequestMapping(method = RequestMethod.POST, value= "/essencia")
    public Essencia addEssencia(@RequestBody Essencia essencia) {
        return essenciaService.addEssencia(essencia);
    }
}
