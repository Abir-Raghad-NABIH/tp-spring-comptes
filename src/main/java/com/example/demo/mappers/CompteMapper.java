package com.example.demo.mappers;

import com.example.demo.dto.CompteRequestDTO;
import com.example.demo.dto.CompteResponseDTO;
import com.example.demo.entities.Compte;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CompteMapper {

    public Compte toEntity(CompteRequestDTO dto) {
        return Compte.builder()
                .solde(dto.solde())
                .type(dto.type())
                .dateCreation(new Date())
                .build();
    }

    public CompteResponseDTO toDTO(Compte c) {
        return new CompteResponseDTO(c.getId(), c.getSolde(), c.getDateCreation(), c.getType());
    }
}