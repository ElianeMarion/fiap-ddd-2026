package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.interfaces.Exibivel;

/**
 * Classe abstrata e genérica que representa uma pessoa no ecossistema da escola de música.
 * Implementa a interface Exibivel para que todas as especializações herdem e sobrescrevam
 * o comportamento de exibição de dados.
 *
 * @author Eliane Marion
 */
public abstract class Pessoa implements Exibivel {
    private String nome;
    protected String cpf;
    private String email;

    /**
     * Construtor para inicializar os atributos comuns de qualquer pessoa.
     *
     * @param nome  Nome completo da pessoa
     * @param cpf   Cadastro de Pessoa Física (CPF)
     * @param email Endereço de correio eletrônico (e-mail)
     */
    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    //Métodos getters e setters com encapsulamento completo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
