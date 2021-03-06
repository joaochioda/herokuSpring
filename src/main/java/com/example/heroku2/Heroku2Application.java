package com.example.heroku2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Heroku2Application {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Banco";
	}

	public static void main(String[] args) {
		SpringApplication.run(Heroku2Application.class, args);
	}

}
