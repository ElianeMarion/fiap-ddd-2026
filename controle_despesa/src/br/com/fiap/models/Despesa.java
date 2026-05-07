package br.com.fiap.models;

public abstract class Despesa {
    protected String descricao;
    protected double valorTotal;

    public void cadastrarDespesa(String descricao){
        this.descricao = descricao;
        this.valorTotal = 0;
    }
    public abstract double calcularDespesa();
    public abstract String listarDespesa();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
