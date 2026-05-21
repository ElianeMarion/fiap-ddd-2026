package br.fiap.models;

import br.fiap.interfaces.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private double avaliacao;
    private int totalVisualizacoes;
    private Integer numeroTemporada;

    public Episodio(int numeroTemporada, Episodio d) {
        this.numeroTemporada = numeroTemporada;
        this.numero = d.numero;
        this.nome = d.nome;
        this.avaliacao = d.avaliacao;
        this.totalVisualizacoes = d.totalVisualizacoes;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public Episodio(int numero, String nome, double avaliacao, int totalVisualizacoes) {
        this.numero = numero;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.totalVisualizacoes = totalVisualizacoes;
    }

    @Override
    public int getClassificacao() {
        if (totalVisualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Episodios da " + numeroTemporada + " temporada " +
                "episódio numero: " + numero +
                ", nome: '" + nome + '\'' +
                ", avaliacao: " + avaliacao;
    }
}
