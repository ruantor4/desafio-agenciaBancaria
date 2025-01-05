package com.torquato.bancoApp.models;

import lombok.Data;

@Data
public class Cliente {

    private String nome;
    private String email;
    private Long cpf;
    
    public Cliente(String nome, String email, Long cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    
    
}