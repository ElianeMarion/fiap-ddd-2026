package br.fiap.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TesteStream {
    public static void main(String[] args) {
        List<Integer> quantidadeDigitos = new ArrayList<>();
        List<String> nomes = List.of("Ana", "Bruno", "Carlos");
        //Trazer uma nova lista com a quantidade de digitos de cada nome
        quantidadeDigitos = nomes.stream()
                .map(nome -> nome.length())
                .collect(Collectors.toList());
        System.out.println(quantidadeDigitos);

        List<List<String >> listaDeLista = List.of(
                List.of("Ana", "Eliane"),
                List.of("Maria", "Jose", "Julio"),
                List.of("Roberto")
        );
        List<String> resultado = listaDeLista.stream()
                .flatMap(lista -> lista.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultado);
    }

}
