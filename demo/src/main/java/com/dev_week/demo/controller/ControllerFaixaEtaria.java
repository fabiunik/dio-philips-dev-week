package com.dev_week.demo.controller;

import java.util.List;
import java.util.Optional;

import com.dev_week.demo.entity.FaixaEtaria;
import com.dev_week.demo.repo.FaixaEtariaRepo;

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
public class ControllerFaixaEtaria {
      
    private FaixaEtariaRepo frepository;

    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try {
            List<FaixaEtaria> lista = frepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByFaixaEtaria(@PathVariable long id){
        try {
            Optional <FaixaEtaria> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()) {
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria postFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return frepository.save(newFaixa);        
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        frepository.deleteById(id);
    }
 
    
}
