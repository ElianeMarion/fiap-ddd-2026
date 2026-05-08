package br.com.fiap.tests;

import br.com.fiap.models.Alimentacao;
import br.com.fiap.models.Diaria;
import br.com.fiap.models.GerenciadorDespesas;
import br.com.fiap.models.Transporte;

import java.util.Scanner;

public class TesteDespesa {

    public static void subMenu(){
        System.out.println("Digite a opção desejada" +
                "\n1 - Cadastrar despesa" +
                "\n2 - Calcular despesa" +
                "\n3 - Apresentar despesa" +
                "\n4 - Incluir despesa para analise" +
                "\n0 - Voltar ao menu principal");
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        int op = 0, opSub = 0;
        Alimentacao alimentacao = new Alimentacao();
        Transporte transporte = new Transporte();
        Diaria diaria = new Diaria();
        GerenciadorDespesas gerenciador = new GerenciadorDespesas();

        do{
            System.out.println("Digite a opção desejada" +
                    "\n1 - Alimentação" +
                    "\n2 - Transporte" +
                    "\n3 - Diária" +
                    "\n4 - Analise de despesas" +
                    "\n0 - Sair");
            op = leitorNumerico.nextInt();
            switch (op){
                case 1:{
                    do {
                        subMenu();
                        opSub = leitorNumerico.nextInt();
                        switch (opSub) {
                            case 1 -> {
                                System.out.println("Informe a descrição da despesa");
                                String descricao = leitor.nextLine();
                                alimentacao.cadastrarDespesa(descricao);
                            }
                            case 2 -> alimentacao.calcularDespesa();
                            case 3 -> System.out.println(alimentacao.listarDespesa());
                            case 4 -> gerenciador.analisarDespesa(alimentacao);
                        }
                    }while (opSub != 0);
                }
            }
        }while(op != 0);
        System.out.println("Despesa total da viagem: R$ " + gerenciador.getTotalDespesa());
    }
}
