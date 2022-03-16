package com.dev_week.demo.repo;

import com.dev_week.demo.entity.Regiao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegiaoRepo extends JpaRepository<Regiao, Long> {
    
}
