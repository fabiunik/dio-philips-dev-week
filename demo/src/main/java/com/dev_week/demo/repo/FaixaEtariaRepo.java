package com.dev_week.demo.repo;

import com.dev_week.demo.entity.FaixaEtaria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaixaEtariaRepo extends JpaRepository<FaixaEtaria, Long> {
    
}
