package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.interfaces.Exibivel;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Aluno matriculado na escola de música.
 * Especialização da classe abstrata Pessoa. Possui idade e gerencia
 * os cursos em que está matriculado por meio de uma lista.
 */
public class Aluno extends Pessoa implements Exibivel {
    // Atributos encapsulados
    private int idade;
    private List<Curso> cursosMatriculados;

    /**
     * Construtor para inicialização completa do Aluno.
     * Inicializa a lista de cursos internamente utilizando ArrayList.
     *
     * @param nome  Nome do aluno
     * @param cpf   CPF do aluno
     * @param email E-mail do aluno
     * @param idade Idade do aluno
     */
    public Aluno(String nome, String cpf, String email, int idade) {
        super(nome, cpf, email);
        this.idade = idade;
        this.cursosMatriculados = new ArrayList<>();
    }

    /**
     * Adiciona um curso à grade de disciplinas do aluno.
     * Esse método é de uso interno/auxiliar na matrícula para assegurar consistência.
     *
     * @param curso Curso a ser adicionado
     */
    public void adicionarCurso(Curso curso) {
        if (curso != null && !this.cursosMatriculados.contains(curso)) {
            this.cursosMatriculados.add(curso);
        }
    }

    /**
     * Remove um curso da grade de disciplinas do aluno.
     *
     * @param curso Curso a ser removido
     */
    public void removerCurso(Curso curso) {
        if (curso != null) {
            this.cursosMatriculados.remove(curso);
        }
    }

    // Getters e Setters com encapsulamento

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna a lista de cursos matriculados.
     * Mantém o controle sobre a coleção de forma encapsulada.
     *
     * @return Lista contendo os cursos do aluno
     */
    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<Curso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    /**
     * Implementação polimórfica do método exibirInformacoes().
     * Apresenta os dados cadastrais do aluno e resume as turmas em que está presente.
     */
    @Override
    public void exibirInformacoes() {
        System.out.println("================ DETALHES DO ALUNO ================");
        System.out.println("Nome:  " + getNome());
        System.out.println("CPF:   " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Idade: " + idade + " anos");
        System.out.print("Cursos:");
        if (cursosMatriculados.isEmpty()) {
            System.out.println(" Nenhum curso vinculado no momento.");
        } else {
            System.out.println();
            for (Curso curso : cursosMatriculados) {
                System.out.println("  - " + curso.getNome() + " [" + curso.getNivel().getDescricao() + "]");
            }
        }
        System.out.println("===================================================");
    }


}
