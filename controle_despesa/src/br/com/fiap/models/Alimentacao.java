package br.com.fiap.models;

public class Alimentacao extends Despesa{

    private String nomeRestaurante;
    private int qtdRefeicao;

    public void casdastrarDespesa(String descricao, int qtdRefeicao){
        super.cadastrarDespesa(descricao);
        this.qtdRefeicao = qtdRefeicao;
    }
    @Override
    public double calcularDespesa() {
        return qtdRefeicao * 18;
    }

    @Override
    public String listarDespesa() {
        String mensagem = "Despesa de alimentação\n" +
                "--------------------------------\n" +
                "Descrição: " + descricao +
                "\nRestaurante: " + nomeRestaurante +
                "\nQuantidade de refeições: " + qtdRefeicao +
                "\nGastos com alimentação: R$" + calcularDespesa();
        return mensagem;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public int getQtdRefeicao() {
        return qtdRefeicao;
    }

    public void setQtdRefeicao(int qtdRefeicao) {
        this.qtdRefeicao = qtdRefeicao;
    }
}
