package com.example.demo.dto;

import com.example.demo.entities.TypeCompte;

public record CompteRequestDTO(Double solde, TypeCompte type) {}