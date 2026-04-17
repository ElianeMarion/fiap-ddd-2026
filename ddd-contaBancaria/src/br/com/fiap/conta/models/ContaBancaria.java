package br.com.fiap.conta.models;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String titular;

    public ContaBancaria(String numeroConta, String titular){
        this.numeroConta = numeroConta;
        this.titular = titular;
    }
    // ++ soma 1 | -- subtrai 1
    //idade++;
    public void depositar(double valor){
        //saldo = saldo + valor;
        if(valor > 0){
            saldo += valor;
        }
        else{
            System.out.println("Valor negativo, não é possível depositar");
        }
    }

    public void sacar(double valor){
        if(saldo > 0 && valor > 0 && saldo >= valor){
            saldo -= valor; //saldo = saldo - valor;
        }else{
            System.out.println("Saque não permitido");
        }
    }

    public String getTitular(){
        return  titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
