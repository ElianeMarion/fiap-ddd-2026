package br.com.fiap.conta.tests;

import br.com.fiap.conta.models.ContaBancaria;
import br.com.fiap.conta.models.ContaCorrente;

public class TesteConta {
    public static void main(String[] args) {
        ContaBancaria cc = new ContaBancaria("12345", "Eliane");
        ContaCorrente contaCorrente = new ContaCorrente("321", "Eliane");

    }
}
