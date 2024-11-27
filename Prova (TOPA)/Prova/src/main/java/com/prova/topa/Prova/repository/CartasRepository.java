package com.prova.topa.Prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.topa.Prova.model.CartasEntity;

public interface CartasRepository extends JpaRepository<CartasEntity, Long> {
    
}
