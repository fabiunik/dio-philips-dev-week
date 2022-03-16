package com.dev_week.demo.controller;

import java.util.List;
import java.util.Optional;

import com.dev_week.demo.entity.Regiao;
import com.dev_week.demo.repo.RegiaoRepo;

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
public class ControllerRegiao {

    private final RegiaoRepo repository;
   
    public ControllerRegiao(RegiaoRepo repository){
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return repository.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional <Regiao> regiaoEscolhidaOptional = repository.findById(id);  
        if (regiaoEscolhidaOptional.isPresent()){
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao postRegiao(@RequestBody Regiao newRegiao){
        return repository.save(newRegiao);
    }
    
    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);

    }
}
