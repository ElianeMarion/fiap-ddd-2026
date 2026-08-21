package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteExclusao {
    static void main() {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        System.out.println("Exclusão do contato");
        System.out.println("==============================");
        System.out.println("Digite o código: ");
        contato.setId(leitorNum.nextInt());
        dao.excluir(contato.getId());
        System.out.println("Registro excluído!");
    }
}
