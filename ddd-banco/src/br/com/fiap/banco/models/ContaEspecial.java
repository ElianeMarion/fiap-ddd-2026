package br.com.fiap.banco.models;

import br.com.fiap.banco.enums.SituacaoEnum;

import java.time.LocalDate;

public class ContaEspecial extends ContaComum{
    private double limite;

    public Long abrirConta(int senha, double limite){
        this.limite = limite;
        return super.abrirConta(senha);
    }
    public String sacarValor(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor; //saldo = saldo - valor
            return "Saque efetuado com sucesso";
        }else if (valor <= saldo + limite){
            limite = limite - (saldo + valor);
            saldo = 0;
            return "Saque efetuado, com uso do limite";
        }else{
            return "Saque não efetuado, saldo insuficiente";
        }
    }


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
