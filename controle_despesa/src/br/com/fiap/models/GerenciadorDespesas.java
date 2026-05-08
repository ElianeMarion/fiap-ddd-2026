package br.com.fiap.models;

public class GerenciadorDespesas {
    private int qtdeAlimentacao;
    private int qtdeTransporte;
    private int qtdeDiaria;
    private double totalAlimentacao;
    private double totalTransporte;
    private double totalDiaria;
    private double totalDespesa;

    public void analisarDespesa(Despesa despesa){
        if(despesa instanceof Transporte){
            qtdeTransporte++;
            totalTransporte += despesa.getValorTotal();
        }else if(despesa instanceof  Alimentacao){
            qtdeAlimentacao++;
            totalAlimentacao += despesa.getValorTotal();
        }else {
            qtdeDiaria++;
            totalAlimentacao += despesa.getValorTotal();
        }
        totalDespesa = totalAlimentacao + totalDiaria + totalTransporte;
    }

    public double getTotalDespesa() {
        return totalDespesa;
    }
}
