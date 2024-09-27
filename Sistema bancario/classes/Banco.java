package classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    //att
    private Map<String, Conta> contas = new HashMap<>();

    //met
    public void registrarConta(Conta conta) {
        contas.put(conta.getDono(), conta);
    }

    public void saldoFinalClientes(Conta conta) {
        System.out.printf("%s: %.2f\n", conta.getDono(), conta.getSaldo());
    }

    public void saldoFinalFuncionariosSalario(Conta conta) {
        System.out.printf("%s : %.2f\n", conta.getDono(), conta.getSaldo());
    }

    public void saldoFinalFuncionariosInvestimento(Conta conta) {
        System.out.printf("%s %.2f\n", conta.getDono(), conta.getSaldo());
    }

    public void saldoFinalLojas(Conta conta) {
        System.out.printf("%s: %.2f\n", conta.getDono(), conta.getSaldo());
    }

    public synchronized void coordenarTransacao(Runnable transacao) {
        transacao.run();
    }

    public void depositar(Conta conta, double valor) {
        coordenarTransacao(() -> {
            conta.depositar(valor);
            exibirSeparador("Depósito");
            System.out.printf("Depósito de %.2f realizado na conta %s\n", valor, conta.getDono());
        });
    }

    public void sacar(Conta conta, double valor) {
        coordenarTransacao(() -> {
            exibirSeparador("Saque");
            if (conta.getSaldo() >= valor) {
                conta.sacar(valor);
                System.out.printf("Saque de %.2f realizado na conta %s\n", valor, conta.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque na conta " + conta.getDono());
            }
        });
    }

    private void exibirSeparador(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }
}