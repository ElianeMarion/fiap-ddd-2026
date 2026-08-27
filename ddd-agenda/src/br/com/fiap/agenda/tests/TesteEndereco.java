package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.EnderecoDAO;
import br.com.fiap.agenda.models.Endereco;

import java.util.List;
import java.util.Scanner;

public class TesteEndereco {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("       CRUD DE ENDEREÇO");
            System.out.println("==============================");
            System.out.println("1 - Inserir endereço");
            System.out.println("2 - Alterar endereço");
            System.out.println("3 - Excluir endereço");
            System.out.println("4 - Buscar endereço por código");
            System.out.println("5 - Listar todos os endereços");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    inserirEndereco(scanner, enderecoDAO);
                    break;

                case 2:
                    alterarEndereco(scanner, enderecoDAO);
                    break;

                case 3:
                    excluirEndereco(scanner, enderecoDAO);
                    break;

                case 4:
                    buscarPorId(scanner, enderecoDAO);
                    break;

                case 5:
                    listarEnderecos(enderecoDAO);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ==========================================
    // INSERIR
    // ==========================================
    private static void inserirEndereco(
            Scanner scanner,
            EnderecoDAO enderecoDAO) {

        System.out.println("\n--- INSERIR ENDEREÇO ---");

        Endereco endereco = new Endereco();

        System.out.print("Código: ");
        endereco.setCodigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Rua/Logradouro: ");
        endereco.setRua(scanner.nextLine());

        System.out.print("CEP: ");
        endereco.setCep(scanner.nextLine());

        System.out.print("Bairro: ");
        endereco.setBairro(scanner.nextLine());

        System.out.print("Cidade: ");
        endereco.setCidade(scanner.nextLine());

        System.out.print("Estado: ");
        endereco.setEstado(scanner.nextLine());

        System.out.print("UF: ");
        endereco.setUf(scanner.nextLine());

        System.out.print("Número: ");
        endereco.setNumero(scanner.nextLine());

        System.out.print("Complemento: ");
        endereco.setComplemento(scanner.nextLine());

        enderecoDAO.inserir(endereco);

        System.out.println("Endereço inserido com sucesso!");
    }

    // ==========================================
    // ALTERAR
    // ==========================================
    private static void alterarEndereco(
            Scanner scanner,
            EnderecoDAO enderecoDAO) {

        System.out.println("\n--- ALTERAR ENDEREÇO ---");

        System.out.print("Digite o código do endereço: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Endereco endereco = enderecoDAO.buscarPorId(codigo);

        if (endereco.getCodigo() == 0) {
            System.out.println("Endereço não encontrado!");
            return;
        }

        System.out.println("Endereço encontrado.");
        System.out.println("Rua atual: " + endereco.getRua());
        System.out.println("CEP atual: " + endereco.getCep());

        System.out.print("Nova rua/logradouro: ");
        endereco.setRua(scanner.nextLine());

        System.out.print("Novo CEP: ");
        endereco.setCep(scanner.nextLine());

        System.out.print("Novo bairro: ");
        endereco.setBairro(scanner.nextLine());

        System.out.print("Nova cidade: ");
        endereco.setCidade(scanner.nextLine());

        System.out.print("Novo estado: ");
        endereco.setEstado(scanner.nextLine());

        System.out.print("Nova UF: ");
        endereco.setUf(scanner.nextLine());

        System.out.print("Novo número: ");
        endereco.setNumero(scanner.nextLine());

        System.out.print("Novo complemento: ");
        endereco.setComplemento(scanner.nextLine());

        enderecoDAO.alterar(endereco);

        System.out.println("Endereço alterado com sucesso!");
    }

    // ==========================================
    // EXCLUIR
    // ==========================================
    private static void excluirEndereco(
            Scanner scanner,
            EnderecoDAO enderecoDAO) {

        System.out.println("\n--- EXCLUIR ENDEREÇO ---");

        System.out.print("Digite o código do endereço: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Endereco endereco = enderecoDAO.buscarPorId(codigo);

        if (endereco.getCodigo() == 0) {
            System.out.println("Endereço não encontrado!");
            return;
        }

        System.out.println("Endereço encontrado:");
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("Cidade: " + endereco.getCidade());

        System.out.print("Deseja realmente excluir? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {

            enderecoDAO.excluir(codigo);

            System.out.println("Endereço excluído com sucesso!");

        } else {

            System.out.println("Exclusão cancelada.");
        }
    }

    // ==========================================
    // BUSCAR POR ID
    // ==========================================
    private static void buscarPorId(
            Scanner scanner,
            EnderecoDAO enderecoDAO) {

        System.out.println("\n--- BUSCAR ENDEREÇO ---");

        System.out.print("Digite o código do endereço: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Endereco endereco = enderecoDAO.buscarPorId(codigo);

        if (endereco.getCodigo() == 0) {
            System.out.println("Endereço não encontrado!");
            return;
        }

        System.out.println("\nEndereço encontrado:");
        System.out.println("------------------------------");
        System.out.println("Código: " + endereco.getCodigo());
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("CEP: " + endereco.getCep());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("UF: " + endereco.getUf());
        System.out.println("Número: " + endereco.getNumero());
        System.out.println("Complemento: " + endereco.getComplemento());
        System.out.println("------------------------------");
    }

    // ==========================================
    // LISTAR TODOS
    // ==========================================
    private static void listarEnderecos(
            EnderecoDAO enderecoDAO) {

        System.out.println("\n--- TODOS OS ENDEREÇOS ---");

        List<Endereco> enderecos =
                enderecoDAO.buscarTodosEnderecos();

        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço cadastrado.");
            return;
        }

        for (Endereco endereco : enderecos) {
            //Posso utilizar System.out.println(endereco);
            System.out.println("------------------------------");
            System.out.println("Código: " + endereco.getCodigo());
            System.out.println("Rua: " + endereco.getRua());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Estado: " + endereco.getEstado());
            System.out.println("UF: " + endereco.getUf());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("Complemento: " + endereco.getComplemento());
        }

        System.out.println("------------------------------");
    }
}
