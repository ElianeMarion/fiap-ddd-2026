package br.com.fiap.banco.tests;

import br.com.fiap.banco.models.Cliente;
import br.com.fiap.banco.models.ContaComum;
import br.com.fiap.banco.models.ContaEspecial;

public class TesteContas {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Eliane");

        ContaComum contaComum = new ContaComum();
        contaComum.abrirConta(123);
        contaComum.setCliente(cliente);
        System.out.println(contaComum.getNroConta() + " saldo: " + contaComum.getSaldo());

        ContaEspecial ce = new ContaEspecial();
        ce.setCliente(cliente);
        ce.abrirConta(456, 2000);
    }
}
