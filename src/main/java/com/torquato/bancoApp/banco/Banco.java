package com.torquato.bancoApp.banco;

import java.util.ArrayList;
import java.util.Scanner;

import com.torquato.bancoApp.models.Cliente;
import com.torquato.bancoApp.models.Conta;
import com.torquato.bancoApp.models.ContaCorrente;
import com.torquato.bancoApp.models.ContaPoupanca;

import lombok.Data;

@Data
public class Banco {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contas;
    static ArrayList<Cliente> clientes;
    public static void main(String[] args) {
        contas = new ArrayList<>();
        clientes = new ArrayList<>();
        operacoes();
    }
    public static void operacoes() {
        System.out.println("Qual operação você deseja fazer: ");
        System.out.println("Opção 1 - Criar conta");
        System.out.println("Opção 2 - Sacar");
        System.out.println("Opção 3 - Depositar");
        System.out.println("Opção 4 - Transferir");
        System.out.println("Opção 5 - Listar contas");
        System.out.println("Opção 6 - Sair");
        int operacao = sc.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                sacar();
                break;
            case 3:
                depositar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agencia");
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida!");
                operacoes();
                break;
        }
    }
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contas.size() > 0) {
            for (Conta c : contas) {
                if (c.getNumero() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }
    public static void depositar() {
        System.out.println("Numero da conta");
        int numeroConta = sc.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }
    public static void criarConta() {
        System.out.println("Qual tipo de conta deseja criar? (Conta Corrente ou Conta Poupança)");
        sc.nextLine();
        String tipoConta = sc.nextLine().toLowerCase();
        System.out.println("Digite seu nome:");
        String nome = sc.next();
        System.out.println("Digite seu email:");
        sc.nextLine();
        String email  = sc.nextLine();
        System.out.println("Digite seu cpf:");
        long cpf = sc.nextLong();
        Cliente cliente = new Cliente(nome, email, cpf);
        if (tipoConta.contains("corrente") || tipoConta.contains("conta corrente")) {
            tipoConta = ("Conta Corrente");
            Conta cc = new ContaCorrente(cliente, tipoConta);
            contas.add(cc);
            clientes.add(cliente);
            System.out.println("Conta criada com sucesso");
        } else if (tipoConta.contains("poupança") || tipoConta.contains("poupanca")
                || tipoConta.contains("conta poupança") || tipoConta.contains("conta poupanca")) {
            tipoConta = ("Conta Poupança");
            Conta cp = new ContaPoupanca(cliente, tipoConta);
            contas.add(cp);
            clientes.add(cliente);
            System.out.println("Conta criada com sucesso");
        } else {
            System.out.println("Opção não reconhecida. Tente novamente.");
        }
        operacoes();
    }
    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = sc.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Qual valor deseja Sacar?");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }
    public static void transferir() {
        System.out.println("Numero da conta do remetente: ");
        int NumeroContaRemetente = sc.nextInt();
        Conta contaRemetente = encontrarConta(NumeroContaRemetente);
        if (contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numeroContaDestinatario = sc.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if (contaDestinatario != null) {
                System.out.println("Valor da transferencia: ");
                double valor = sc.nextDouble();
                contaRemetente.transferir(valor, contaDestinatario);
            } else {
                System.out.println("Conta para deposito não encontrada");
            }
        } else {
            System.out.println("A conta para transferencia nao encontrada");
        }
        operacoes();
    }
    
    public static void listarContas() {
        if (contas.size() > 0) {
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
