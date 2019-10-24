package com.example.heroku2.controller;

import com.example.heroku2.model.CadastrarTudo;
import com.example.heroku2.model.Essencia;
import com.example.heroku2.service.EssenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EssenciaController {

    @Autowired
    private EssenciaService essenciaService;

    @RequestMapping(method = RequestMethod.POST, value= "/essencia")
    public Essencia addEssencia(@RequestBody Essencia essencia) {
        return essenciaService.addEssencia(essencia);
    }

    @RequestMapping(method = RequestMethod.GET, value="/essencia/{id}")
    public Essencia getEssenciaById(@PathVariable Long id) {
        return essenciaService.getEssenciaById(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/essencia")
    public List<Essencia> getAllEssencia() {
        return essenciaService.getAllEssencia();
    }

    @RequestMapping(method = RequestMethod.POST, value="/cadastrartudo")
    public void cadastrarTudo(@RequestBody List<CadastrarTudo> cadastrarTudo) {
        essenciaService.cadastrarTudo(cadastrarTudo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/essencia/{id}")
    public Essencia deleteEssencia(@PathVariable Long id) {
        return essenciaService.deleteEssencia(id);
    }
}
