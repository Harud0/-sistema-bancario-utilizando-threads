package classes;

public class Conta {
    // att
    private String dono;
    private double saldo;
    private Cliente cliente;

    // const
    public Conta(String dono, double saldo, Cliente cliente) {
        this.dono = dono;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    // met
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        }
    }

    // get e set
    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}