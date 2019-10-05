package com.example.heroku2.controller;

import com.example.heroku2.model.Marca;
import com.example.heroku2.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @RequestMapping(method = RequestMethod.POST, value = "/marca")
    public Marca addMarca(@RequestBody Marca marca) {
        return marcaService.addMarca(marca);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/marca")
    public List<Marca> getAllMarcas() {
        return marcaService.getAllMarcas();
    }
}
