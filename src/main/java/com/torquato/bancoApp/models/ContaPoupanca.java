package com.torquato.bancoApp.models;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente, String tipoConta){
      super(cliente); 
      this.tipoConta = tipoConta;
    }
      
      public void imprimirExtrato() {
        System.out.println("===== EXTRATO CONTA POUPANÇA =====");
       
      }
    
  }