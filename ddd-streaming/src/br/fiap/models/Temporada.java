package br.fiap.models;

import java.util.List;

public class Temporada {

    private int numeroTemporada;
    private List<Episodio> episodios;

    public Temporada(int numeroTemporada, List<Episodio> episodios) {
        this.numeroTemporada = numeroTemporada;
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "numeroTemporada=" + numeroTemporada +
                ", episodios=" + episodios +
                '}';
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
}
