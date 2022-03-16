package com.dev_week.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regiao {
    
    //apesar de ter usado lombok foi necessário criar esses construtores na hora do teste
    public Regiao(long l, String string, int i) {
    }
    public Regiao(String string, int i) {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(nullable = false, updatable = false) 
    private Long id;
    private String regiao;
    private Long total_exames;
}
