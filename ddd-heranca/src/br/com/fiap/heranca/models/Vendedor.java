package br.com.fiap.heranca.models;

public class Vendedor extends Funcionario{
    private double comissao;
    public double calculoComissao(double valorVendido){
        return  valorVendido * 1.1 + getSalario();
    }
    public double calculaBonificacao(){
        return super.calculaBonificacao() + 500;
    }
}
