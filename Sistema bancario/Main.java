import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        //funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Pablo Borçal", 1400.00, banco));
        funcionarios.add(new Funcionario("Datena Cadeirada", 1400.00, banco));
        funcionarios.add(new Funcionario("Boulos farinha", 1400.00, banco));
        funcionarios.add(new Funcionario("Azulzinha pesadelo", 1400.00, banco));

        for (Funcionario funcionario : funcionarios) {
            banco.registrarConta(funcionario.getContaSalario());
            banco.registrarConta(funcionario.getContaInvestimentos());
            funcionario.start();
        }

        //lojas
        Conta contaAmazon = new Conta("Jeff Bezos", 0, null);
        Conta contaShopee = new Conta("Forrest Li", 0, null);

        Loja amazon = new Loja("Amazon", funcionarios.get(0), contaAmazon);
        amazon.adicionarFuncionario(funcionarios.get(1));

        Loja shopee = new Loja("Shopee", funcionarios.get(2), contaShopee);
        shopee.adicionarFuncionario(funcionarios.get(3));

        banco.registrarConta(contaAmazon);
        banco.registrarConta(contaShopee);

        //clientes
        List<Cliente> clientes = new ArrayList<>();
        String[] nomesClientes = {"Eduardo", "Moises", "Lulu", "Carvalho", "Judas", "Sara", "Maria", "Mila", "Carol", "Ceci"};

        for (String nome : nomesClientes) {
            Cliente cliente = new Cliente(nome, amazon, shopee, banco);
            banco.registrarConta(cliente.getConta());
            clientes.add(cliente);
            cliente.start();
        }

        //termino das threads
        for (Funcionario funcionario : funcionarios) {
            try {
                funcionario.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //saldo final das contas
        System.out.println("\nSaldo final dos Clientes:\n");
        for(Cliente cliente : clientes){
            banco.saldoFinalClientes(cliente.getConta());
        }
        System.out.println("\nSaldo final dos Funcionarios:");
        System.out.println("\nConta Salario ");
        for (Funcionario funcionario : funcionarios){
            banco.saldoFinalFuncionariosSalario(funcionario.getContaSalario());
        }

        System.out.println("\nConta Investimento");
        for (Funcionario funcionario : funcionarios){
            banco.saldoFinalFuncionariosInvestimento(funcionario.getContaInvestimentos());
        }

        System.out.println("\nSaldo final das Lojas:\n");
        banco.saldoFinalLojas(contaAmazon);
        banco.saldoFinalLojas(contaShopee);

    }
}