package classes;

import java.util.Random;

public class Cliente extends Thread {
    // att
    private String nome;
    private Conta conta;
    private Loja l1;
    private Loja l2;
    private Banco banco;

    // const
    public Cliente(String nome, Loja l1, Loja l2, Banco banco) {
        this.nome = nome;
        this.conta = new Conta(nome, 2000, this);
        this.l1 = l1;
        this.l2 = l2;
        this.banco = banco;
    }

    // met
    @Override
    public void run() {
        realizarCompras(l1);
        realizarCompras(l2);
    }

    private void realizarCompras(Loja loja) {
        for (int i = 0; i < 2; i++) {
            double valorCompra = randomValue(200, 500);
            pagar(loja, valorCompra);
        }
    }

    public void pagar(Loja loja, double valor) {
        banco.sacar(conta, valor);
        banco.depositar(loja.getConta(), valor);
        System.out.printf("Cliente %s pagou %.2f a loja %s\n", nome, valor, loja.getNome());
    }

    private double randomValue(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }


    // get e set
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

    public Loja getLoja1() {
        return l1;
    }

    public void setLoja1(Loja loja1) {
        this.l1 = loja1;
    }

    public Loja getLoja2() {
        return l2;
    }

    public void setLoja2(Loja loja2) {
        this.l2 = loja2;
    }
}