package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteCadastro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        System.out.println("Cadastro de contatos");
        System.out.println("==============================");
        System.out.println("Digite o código: ");
        contato.setId(leitorNum.nextInt());
        System.out.println("Digite o nome: ");
        contato.setNome(leitor.nextLine());
        System.out.println("Digite o celular:");
        contato.setCelular(leitor.nextLine());
        System.out.println("Digite o email:");
        contato.setEmail(leitor.nextLine());
        System.out.println("Digite o instagram:");
        contato.setInstagram(leitor.nextLine());
        System.out.println("Tipo do contato: AMIGO, FAMILIAR, PROFISSIONAL");
        contato.setTipo(leitor.nextLine());

        dao.cadastrar(contato);
        System.out.println("Contato foi adicionado com sucesso!");
    }

}
