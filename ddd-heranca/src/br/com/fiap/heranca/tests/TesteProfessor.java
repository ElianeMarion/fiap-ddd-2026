package br.com.fiap.heranca.tests;

import br.com.fiap.heranca.models.Professor;

public class TesteProfessor {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNome("Eliane");
        professor.setCtps("2335656");
        professor.setQtdHoras(40);
        professor.setValorHora(150);
        professor.setCpf("123456789");
        professor.setEmail("emarion@teste.com");

        double salario = professor.calcularSalario();
        System.out.println(professor.exibirDados());
    }
}
