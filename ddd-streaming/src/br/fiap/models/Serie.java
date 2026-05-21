package br.fiap.models;

import java.util.List;

public class Serie extends Titulo{

    private int numeroTemporada;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    private List<Temporada> temporadas;

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }


    public Serie(String nome, int anoDeLancamento, int duracaoEmMinutos, int numeroTemporada, boolean ativa, int episodiosPorTemporada, int minutosPorEpisodio, List<Temporada> temporadas) {
        super(nome, anoDeLancamento, duracaoEmMinutos);
        this.numeroTemporada = numeroTemporada;
        this.ativa = ativa;
        this.episodiosPorTemporada = episodiosPorTemporada;
        this.minutosPorEpisodio = minutosPorEpisodio;
        this.temporadas = temporadas;
    }

    public Serie(String nome, int anoDeLancamento, int duracaoEmMinutos, double somaAvaliacao, int totalAvaliacoes, ClassificacaoEnum classificacaoIndicativa, int numeroTemporada, boolean ativa, int episodiosPorTemporada, int minutosPorEpisodio, List<Temporada> temporadas) {
        super(nome, anoDeLancamento, duracaoEmMinutos, somaAvaliacao, totalAvaliacoes, classificacaoIndicativa);
        this.numeroTemporada = numeroTemporada;
        this.ativa = ativa;
        this.episodiosPorTemporada = episodiosPorTemporada;
        this.minutosPorEpisodio = minutosPorEpisodio;
        this.temporadas = temporadas;
    }

    public Serie() {
    }

    public Serie(String lucifer, int i, boolean b, double v, int i1, int i2, boolean b1, int i3, int i4, List<Temporada> temporadas, int i5) {
        super();
    }
    @Override
    public String toString() {
        return "Serie " +
                "numeroTemporada =" + numeroTemporada +
                ", ativa =" + ativa +
                ", episodiosPorTemporada =" + episodiosPorTemporada +
                ", minutosPorEpisodio =" + minutosPorEpisodio +
                ", temporadas =" + temporadas;
    }

    @Override
    public void exibirFichaTecnica(){
        super.exibirFichaTecnica();
        System.out.println(duracaoEmMinutos);
        System.out.println("Número de temporadas: " + numeroTemporada);
        System.out.println("Quantidade de episódios por temporada: " + episodiosPorTemporada);
        System.out.println("Tempo por episódio em minutos: " + minutosPorEpisodio);
        if(ativa)
            System.out.println("Série está ativa");
        else
            System.out.println("A série já foi finalizada, aproveite para maratonar!!!");
    }

    @Override
    public void somarNotas(double nota) {

    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
}
