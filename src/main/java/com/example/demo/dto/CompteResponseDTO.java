package com.example.demo.dto;

import com.example.demo.entities.TypeCompte;
import java.util.Date;

public record CompteResponseDTO(Long id, Double solde, Date dateCreation, TypeCompte type) {}