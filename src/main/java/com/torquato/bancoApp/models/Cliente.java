package com.torquato.bancoApp.models;

import lombok.Data;

@Data
public class Cliente {

    private String nome;
    private String email;
    private Long cpf;

    
}