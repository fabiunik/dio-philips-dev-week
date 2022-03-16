package com.dev_week.demo.controller;

import java.util.List;
import java.util.Optional;

import com.dev_week.demo.entity.Incidencia;
import com.dev_week.demo.repo.IncidenciaRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {

    
    private final IncidenciaRepo ocRepository;
    
    public ControllerIncidencia(IncidenciaRepo ocRepository) {
        this.ocRepository = ocRepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findIncidencias(){
        List<Incidencia> listaIncidencia = ocRepository.findAll();
        if (listaIncidencia.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);        
    } 

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findIncidenciasById(@PathVariable long id){
        Optional<Incidencia> incidenciaOptional = ocRepository.findById(id);
        if (incidenciaOptional.isPresent()) {
            Incidencia incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia postIncidencia(@RequestBody Incidencia newIncidencia){
        return ocRepository.save(newIncidencia);
    }

    @DeleteMapping("/incidencia/remover/{id}")
    public void deleteIncidencia(@PathVariable Long id) {
        ocRepository.deleteById(id);
    }
}
