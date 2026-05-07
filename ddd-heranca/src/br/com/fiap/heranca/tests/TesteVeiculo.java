package br.com.fiap.heranca.tests;

import br.com.fiap.heranca.models.Caminhao;
import br.com.fiap.heranca.models.Veiculo;

import java.util.Scanner;

public class TesteVeiculo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Caminhao caminhao = new Caminhao();
        int op = 0;
        while (op != 3){
            System.out.println("Digite:\n1 - caminhão\n2 - Van\n 3 - Sair");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    int opcao;
                    do {
                        System.out.println("1- calcular\n2-exibir\n3- Voltar para o menu principal");
                        opcao = leitor.nextInt();
                        if (opcao == 1) {
                            System.out.println(caminhao.validarAutonomia(50));
                        } else if(opcao == 2){
                            System.out.println("relatório");
                        }
                        else{
                            System.out.println("Voltando para o menu principal ....");
                        }
                    } while (opcao != 3);
                    break;
                case 2:
                    System.out.println("1- calcular\n2-exibir");
                    int opcaoVan = leitor.nextInt();
                    if (opcaoVan == 1) {
                        System.out.println(caminhao.validarAutonomia(50));
                    } else {
                        System.out.println("relatório");
                    }
                    break;
            }
        }
    }
}
/*
*  laços condicionais - while (0,n) | do...while (1, n)
 while(cond){

 }
 do{


 while(condicao);

*
*
switch(variavel){
    case valor1: faço break;
    case valor2: comandos_opcao2 break;
    default: caso_nao_entre nos anteriores break;
}
switch(continuar){
    case 'S':
    case 'N':
 }
* */