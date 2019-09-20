package com.example.heroku2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class DatabaseConfigTest {
    public String testDatabaseConfigTest() {
        System.out.println("banco teste h2");
        return "Conectado banco teste com sucesso";
    }
}
