package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.dao.EnderecoDAO;
import br.com.fiap.agenda.models.Contato;
import br.com.fiap.agenda.models.Endereco;

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
        System.out.println("Digite o código do endereço: ");
        int codigo = leitorNum.nextInt();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = new Endereco();
        endereco = enderecoDAO.buscarPorId(codigo);
        if(endereco == null)
            System.out.println("Endereço não cadastro");
        else
            contato.setEndereco(endereco);

        dao.cadastrar(contato);
        System.out.println("Contato foi adicionado com sucesso!");
    }

}
