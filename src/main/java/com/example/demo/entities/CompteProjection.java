package com.example.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection {
    Long getId();
    Double getSolde();
}