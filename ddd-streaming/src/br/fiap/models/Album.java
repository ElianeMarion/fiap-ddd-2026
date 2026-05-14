package br.fiap.models;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nome;
    private String artista;
    private int anoLancamento;
    private int duracao;

    private List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica musica){
        //Método para adicionar um item à lista: add
        musicas.add(musica);
        //duracao += musica.getDuracao();
    }

    public void calcularDuracao(){
        //for convencional
        for(int i=0; i< musicas.size(); i++){
            duracao += musicas.get(i).getDuracao();
        }
        //foreach
        for(Musica musica : this.musicas){
            duracao += musica.getDuracao();
        }
        //método forEach()
        musicas.forEach(musica -> duracao += musica.getDuracao());
    }

    public void removerMusica(Musica musica){
        musicas.remove(musica);
        duracao -= musica.getDuracao();
    }

    public void  exibirLista(){
        System.out.println("Tamanho da lista: " + musicas.size());
        System.out.println("Exibindo a lista com forEach");
        musicas.forEach(musica -> {
            System.out.println("Nome: " + musica.getNome());
            System.out.println("Artista: " + musica.getArtista());
        });

        System.out.println("==============================");
        System.out.println("Primeiro elemento: " + musicas.get(0));
        System.out.println("Exibindo a lista com forEach usando toString (objeto)");
        musicas.forEach(musica -> System.out.println(musica));

        System.out.println("==============================");
        System.out.println("Exibindo a lista com forEach usando método de referência");

        //Para exibir o objeto
        musicas.forEach(System.out::println);

        }

    public Album(String nome, String artista, int anoLancamento,  List<Musica> musicas) {
        this.nome = nome;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.musicas = musicas;
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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
