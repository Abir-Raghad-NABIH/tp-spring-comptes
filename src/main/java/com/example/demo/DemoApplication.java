package com.example.demo;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;
import com.example.demo.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository repo) {
        return args -> {
            for (int i = 0; i < 3; i++) {
                repo.save(Compte.builder()
                        .solde(1000 + Math.random() * 9000)
                        .dateCreation(new Date())
                        .type(Math.random() > 0.5 ? TypeCompte.COURANT : TypeCompte.EPARGNE)
                        .build());
            }
            repo.findAll().forEach(System.out::println);
        };
    }
}