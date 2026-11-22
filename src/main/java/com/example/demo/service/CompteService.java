package com.example.demo.service;

import com.example.demo.dto.CompteRequestDTO;
import com.example.demo.dto.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    CompteResponseDTO save(CompteRequestDTO dto);
    CompteResponseDTO update(Long id, CompteRequestDTO dto);
    List<CompteResponseDTO> findAll();
    CompteResponseDTO findById(Long id);
    void delete(Long id);
}