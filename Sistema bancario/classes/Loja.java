package classes;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    //att
    private String nome;
    private List<Funcionario> funcionarios;
    private Conta conta;

    //const
    public Loja(String nome, Funcionario funcionario, Conta conta) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
        this.funcionarios.add(funcionario);
        this.conta = conta;
    }

    //met
    public void receber_pagamento(double valor){
        conta.depositar(valor);
        System.out.printf("Loja %s recebeu pagamento de %.2f\n", nome, valor);
        pagarFuncionarios();
    }

    public void pagarFuncionarios() {
        double salario = 1400.00;
        for (Funcionario funcionario : funcionarios) {
            if (conta.getSaldo() >= salario) {
                conta.sacar(salario);
                funcionario.getContaSalario().depositar(salario);
                System.out.printf("O funcionário %s recebeu o salario equivalente a: %.2f\n", funcionario.getNome(), salario);
            }
        }
    }

    //get e set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
}