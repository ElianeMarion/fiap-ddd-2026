package br.com.fiap.veiculo.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Veiculo {
    private double valorHora;
    private double valorAdicional;
    private double horas;

    public double doTotal(){
        return  valorHora + valorAdicional * (horas - 1);
    }

    public String doViewCupom(){
        return "Cupom Fiscal" +
                "\n------------------------------" +
                "\nData: " + obterDataPorExtenso() +
                "\nValor hora: " + valorHora +
                "\nValor hora adicional: " + valorAdicional +
                "\nQuantidade de horas: " + horas +
                "\nValor Total sem Desconto: R$ " + doTotal();
    }

    public String obterDataPorExtenso(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d 'de' MMM 'de' yyy");
        String resultado = formatador.format(LocalDateTime.now());
        return resultado;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
}
