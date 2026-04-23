package br.com.fiap.heranca.models;

public class Gerente extends Funcionario{
    private double gratificacao;
    public double calculaBonificacao(){
        return super.calculaBonificacao() + 1000;
    }

    public double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(double gratificacao) {
        this.gratificacao = gratificacao;
    }
}
