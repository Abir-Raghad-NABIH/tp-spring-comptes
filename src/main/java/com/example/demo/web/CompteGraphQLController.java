package com.example.demo.web;

import com.example.demo.dto.CompteRequestDTO;
import com.example.demo.dto.CompteResponseDTO;
import com.example.demo.service.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompteGraphQLController {

    private final CompteService service;

    @QueryMapping
    public List<CompteResponseDTO> allComptes() {
        return service.findAll();
    }

    @QueryMapping
    public CompteResponseDTO compteById(@Argument Long id) {
        return service.findById(id);
    }

    @MutationMapping
    public CompteResponseDTO saveCompte(@Argument CompteRequestDTO compte) {
        return service.save(compte);
    }

    @MutationMapping
    public Boolean deleteCompte(@Argument Long id) {
        service.delete(id);
        return true;
    }
}