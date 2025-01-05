package com.torquato.bancoApp.models;


public class Conta {
    
    private static final int AGENCIA_PADRAO = 0001;
    
    private static int SEQUENCIAL = 1;
    
    private Integer agencia;
    private Integer numero;
    private Double saldo = 0.0;
    private Cliente cliente;
    private String tipoConta;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL;
        this.cliente = cliente;
        SEQUENCIAL += 1;
    }
}