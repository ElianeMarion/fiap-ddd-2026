package br.com.fiap.conta.models;

public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente(String numeroConta, String titular) {
        super(numeroConta, titular);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
