package br.fiap.models;

import br.fiap.interfaces.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        super(nome, anoDeLancamento, duracaoEmMinutos);
    }
    public Filme(){
        super();
    }
    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos, double somaAvaliacao, int totalAvaliacoes, ClassificacaoEnum classificacaoIndicativa) {
        super(nome, anoDeLancamento, duracaoEmMinutos, somaAvaliacao, totalAvaliacoes, classificacaoIndicativa);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void somarNotas(double nota) {
        somaAvaliacao += nota;
    }


    @Override
    public int getClassificacao() {
        return (int) somaAvaliacao / totalAvaliacoes;
    }
}
