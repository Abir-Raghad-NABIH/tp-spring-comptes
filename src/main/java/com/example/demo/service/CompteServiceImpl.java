package com.example.demo.service;

import com.example.demo.dto.CompteRequestDTO;
import com.example.demo.dto.CompteResponseDTO;
import com.example.demo.entities.Compte;
import com.example.demo.mappers.CompteMapper;
import com.example.demo.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository repo;
    private final CompteMapper mapper;

    @Override
    public CompteResponseDTO save(CompteRequestDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public CompteResponseDTO update(Long id, CompteRequestDTO dto) {
        Compte c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte " + id + " introuvable"));
        if (dto.solde() != null) c.setSolde(dto.solde());
        if (dto.type() != null) c.setType(dto.type());
        return mapper.toDTO(repo.save(c));
    }

    @Override
    public List<CompteResponseDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public CompteResponseDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Compte " + id + " introuvable"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}