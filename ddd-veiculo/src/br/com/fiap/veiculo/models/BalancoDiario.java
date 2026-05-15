package br.com.fiap.veiculo.models;

public class BalancoDiario {
    private static int qtdeCarros;
    private static double total;

    public void doAdd(Veiculo obj){
        qtdeCarros++;
        total += obj.doTotal();
    }

    public String doGerarRelatorio(){
        return "\n\nRelatório diário" +
                "\n------------------------------" +
                "\nQuantidade de carros: " + qtdeCarros +
                "\nValor total R$ " + total;

    }
}
