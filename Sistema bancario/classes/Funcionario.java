package classes;

public class Funcionario extends Thread { ;
    // att
    private String nome;
    private double salario;
    private Conta contaSalario;
    private Conta contaInvestimentos;
    private Banco banco;

    // const
    public Funcionario(String nome, double salario, Banco banco) {
        this.nome = nome;
        this.salario = salario;
        this.banco = banco;
        this.contaSalario = new Conta(nome, 0, null);
        this.contaInvestimentos = new Conta(nome, 0, null);
    }

    // met
    @Override
    public void run() {
        receberSalario(salario);
    }

    public void investir() {
        double valorInvestimento = salario * 0.20;
        banco.sacar(contaSalario, valorInvestimento);
        banco.depositar(contaInvestimentos, valorInvestimento);
        System.out.printf("%s investiu %.2f na conta de investimentos.\n", nome, valorInvestimento);
    }

    public void receberSalario(double valor) {
        banco.depositar(contaSalario, valor);
        System.out.printf("%s recebeu salário de %.2f\n", nome, valor);
        investir();
    }

    // get e set
    public String getNome() {
        return nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimentos() {
        return contaInvestimentos;
    }
}