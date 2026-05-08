package br.com.fiap.atributoEstatico;

public class TesteAtributoEstatico {
    public static void main(String[] args) {
        AtributoEstatico a = new AtributoEstatico();
        System.out.println("A: quantidade: " + a.quantidade
                + "\nqtdStatico: " + AtributoEstatico.qtdStatic);

        AtributoEstatico a2 = new AtributoEstatico();
        System.out.println("A2: quantidade: " + a2.quantidade
                + "\nqtdStatico: " + AtributoEstatico.qtdStatic);

    }
}
