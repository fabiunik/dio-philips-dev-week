package com.dev_week.demo.repo;

import com.dev_week.demo.entity.Incidencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo extends JpaRepository<Incidencia, Long> {
    
}
