package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.interfaces.Exibivel;

public class Professor extends Pessoa implements Exibivel {
    private String instrumentoEspecialidade;

    /**
     * Construtor para inicialização de um Professor.
     *
     * @param nome                     Nome do professor
     * @param cpf                      CPF do professor
     * @param email                    E-mail do professor
     * @param instrumentoEspecialidade Instrumento que leciona (ex: Violão, Piano, Bateria)
     */
    public Professor(String nome, String cpf, String email, String instrumentoEspecialidade) {
        super(nome, cpf, email);
        this.instrumentoEspecialidade = instrumentoEspecialidade;
    }

    // Getters e Setters com encapsulamento

    public String getInstrumentoEspecialidade() {
        return instrumentoEspecialidade;
    }

    public void setInstrumentoEspecialidade(String instrumentoEspecialidade) {
        this.instrumentoEspecialidade = instrumentoEspecialidade;
    }

    /**
     * Implementação polimórfica do método exibirInformacoes().
     * Mostra os dados básicos e a especialidade do educador.
     */
    @Override
    public void exibirInformacoes() {
        System.out.println("============== DETALHES DO PROFESSOR ==============");
        System.out.println("Nome:          " + getNome());
        System.out.println("CPF:           " + getCpf());
        System.out.println("Email:         " + getEmail());
        System.out.println("Especialidade: " + instrumentoEspecialidade);
        System.out.println("===================================================");
    }
}
