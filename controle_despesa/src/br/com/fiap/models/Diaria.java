package br.com.fiap.models;

public class Diaria extends Despesa{
    private double qtdDiaria;
    public void cadastrarDespesa(String descricao, double qtdDiaria){
        super.cadastrarDespesa(descricao);
        this.qtdDiaria = qtdDiaria;
    }

    public double getQtdDiaria() {
        return qtdDiaria;
    }

    public void setQtdDiaria(double qtdDiaria) {
        this.qtdDiaria = qtdDiaria;
    }

    @Override
    public double calcularDespesa() {
        return qtdDiaria * 50;
    }

    @Override
    public String listarDespesa() {
        String mensagem = "Despesa de diárias\n" +
                "--------------------------------\n" +
                "Descrição: " + descricao +
                "\nQuantidade de diárias: " + qtdDiaria +
                "\nGastos com diária: R$" + calcularDespesa();
        return mensagem;
    }
}
