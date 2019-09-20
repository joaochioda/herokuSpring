package com.example.heroku2.resource;

import com.example.heroku2.model.Contato;
import com.example.heroku2.repository.Contatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosResource {

    @Autowired
    private Contatos contatos;

    @PostMapping
    public Contato adicionar(@Valid @RequestBody Contato contato) {
        return contatos.save(contato);
    }

    @GetMapping
    public List<Contato> listar() {
        return contatos.findAll();
    }
}
