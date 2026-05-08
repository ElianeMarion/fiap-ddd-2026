package br.com.fiap.atributoEstatico;

public class AtributoEstatico {
    public int quantidade;
    public static int qtdStatic;

    public AtributoEstatico() {
        quantidade++;
        qtdStatic++;
    }
}
