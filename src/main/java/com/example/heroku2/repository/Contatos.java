package com.example.heroku2.repository;

import com.example.heroku2.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Contatos extends JpaRepository<Contato,Long> {
}
