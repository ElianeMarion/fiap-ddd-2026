package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.dao.EnderecoDAO;
import br.com.fiap.agenda.models.Contato;
import br.com.fiap.agenda.models.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteCadastroContatoEntregas {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        List<Endereco> enderecosEntrega = new ArrayList<>();

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

        System.out.println("Gostaria de cadastrar endereços de entrega? [1] - Sim | [2] - Não");
        int op = leitorNum.nextInt();
        while(op == 1){
            System.out.println("Digite o código do endrereço de entrega");
            int codigoEntrega = leitorNum.nextInt();
            Endereco enderecoEntrega = enderecoDAO.buscarPorId(codigoEntrega);
            if(enderecoEntrega == null)
                System.out.println("Endereço não cadastrado!");
            else{
                enderecosEntrega.add(enderecoEntrega);
                System.out.println("Endereço de entrega adicionado com sucesso!");
            }
            System.out.println("Deseja adicionar outro endereço?");
            System.out.println("[1] - Sim | [2] - Não");
            op = leitorNum.nextInt();
        }
        contato.setEnderecosEntrega(enderecosEntrega);

        dao.cadastrarContatoEnderecoEntrega(contato);
        System.out.println("Contato foi adicionado com sucesso!");
    }
}
