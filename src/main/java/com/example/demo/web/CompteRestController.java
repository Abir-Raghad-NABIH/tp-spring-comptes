package com.example.demo.web;

import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api-rest")
@RequiredArgsConstructor
public class CompteRestController {

    private final CompteRepository repo;

    @GetMapping("/comptes")
    public List<Compte> all() { return repo.findAll(); }

    @GetMapping("/comptes/{id}")
    public Compte get(@PathVariable Long id) { return repo.findById(id).orElseThrow(); }

    @PostMapping("/comptes")
    public Compte add(@RequestBody Compte c) {
        c.setDateCreation(new Date());
        return repo.save(c);
    }

    @PutMapping("/comptes/{id}")
    public Compte put(@PathVariable Long id, @RequestBody Compte c) {
        Compte existing = repo.findById(id).orElseThrow();
        if (c.getSolde() != null) existing.setSolde(c.getSolde());
        if (c.getType() != null) existing.setType(c.getType());
        return repo.save(existing);
    }

    @DeleteMapping("/comptes/{id}")
    public void del(@PathVariable Long id) { repo.deleteById(id); }
}