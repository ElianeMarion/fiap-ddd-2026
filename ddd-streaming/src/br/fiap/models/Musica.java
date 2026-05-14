package br.fiap.models;

import br.fiap.interfaces.Reproduzivel;

public class Musica implements Reproduzivel {
    private String nome;
    private String artista;
    private String genero;
    private int duracao;
    private int anoLancamento;

    public String exibir(){
        return nome;
    }
    @Override
    public String toString() {
        return "Música: " + nome + "\nArtista: "
                +  artista;
    }

    public Musica(String nome, String artista, String genero, int duracao, int anoLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if(duracao <= 0){
            System.out.println("A duração da múscia não pode ter valor negativo");
            return;
        }
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public void reproduzir() {
        System.out.println("Tocando a música " + nome);
    }

    @Override
    public void parar() {

    }
}
