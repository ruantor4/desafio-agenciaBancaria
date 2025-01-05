package com.torquato.bancoApp.models;

public class ContaCorrente extends Conta {
    
  public ContaCorrente(Cliente cliente, String tipoConta){
    super(cliente); 
    this.tipoConta = tipoConta;
  }
  
    public void imprimirExtrato() {
      System.out.println("===== EXTRATO CONTA POUPANÇA =====");
      
    }
}