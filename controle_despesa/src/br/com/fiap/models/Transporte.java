package br.com.fiap.models;

public class Transporte extends Despesa{
    private double kmPercorrida;
    private double valorPedagio;

    public void cadastrarDespesa(String descricao, double kmPercorrida, double valorPedagio){
        super.cadastrarDespesa(descricao);
        this.kmPercorrida = kmPercorrida;
        this.valorPedagio = valorPedagio;
    }
    @Override
    public double calcularDespesa() {
        return kmPercorrida * 3 + valorPedagio;
    }

    @Override
    public String listarDespesa() {
        String mensagem = "Despesa de transporte\n" +
                "--------------------------------\n" +
                "Descrição: " + descricao +
                "\nKM percorrida: " + kmPercorrida +
                "\nValor dos pedágios: " + valorPedagio +
                "\nGastos com transporte: R$" + calcularDespesa();
        return mensagem;
    }

    public double getKmPercorrida() {
        return kmPercorrida;
    }

    public void setKmPercorrida(double kmPercorrida) {
        this.kmPercorrida = kmPercorrida;
    }

    public double getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }
}
