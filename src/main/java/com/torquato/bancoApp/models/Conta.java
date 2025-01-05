package com.torquato.bancoApp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Conta{
   
    private static final int AGENCIA_PADRAO = 0001;
    
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected Cliente cliente;
    protected String tipoConta;
    
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL;
        this.cliente = cliente;
        SEQUENCIAL += 1;
    }
    
  
    public void sacar(double valor){
       if(valor > 0 && getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso");
       }else{
            System.out.println("Seu saldo é menor que :" + valor);
        }
    }
    
    public void depositar(double valor) {
        if (valor > 0 ) {
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        }else{
            System.out.println("Não foi possivel realizar o deposito!");
        }
    }
    
    public void transferir(double valor, Conta contaDestinatario) {
        if(valor > 0 && this.getSaldo() >= valor){  
            setSaldo(getSaldo() - valor);  
            
            contaDestinatario.saldo = contaDestinatario.getSaldo() + valor;
            System.out.println("Transferencia de: " + valor + " realizada com sucesso");
        }else{
            System.out.println("Não foi possivel realizar a Transferencia!");
        }
    }
    
    public String toString() {
        return "Conta [Agencia = " + agencia + ", Numero = " + numero + ", Saldo = " + saldo + ", Cliente = " + cliente
                + ", TipoConta = " + tipoConta + "]";
    }
}
