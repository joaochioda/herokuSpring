package com.example.heroku2.repository;

import com.example.heroku2.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository  extends JpaRepository<Marca,Long> {
}
