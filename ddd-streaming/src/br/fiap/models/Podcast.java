package br.fiap.models;

import br.fiap.interfaces.Reproduzivel;

public class Podcast implements Reproduzivel {
    @Override
    public void reproduzir() {
        System.out.println("Disponibilizando o podcast....");
    }

    @Override
    public void parar() {

    }
}
