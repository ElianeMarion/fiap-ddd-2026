package br.com.fiap.banco.models;

import br.com.fiap.banco.enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaComum {
    protected Long nroConta;
    protected LocalDate dtAbertura;
    protected LocalDate dtEncerramento;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;
    protected SituacaoEnum situacao;

    public Long gerarNumeroConta(){
        Random random = new Random();
        return random.nextLong(99999);
    }

    public String sacarValor(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor; //saldo = saldo - valor
            return "Saque efetuado com sucesso";
        }else{
            return "Saque não efetuado, saldo insuficiente";
        }
    }

    public  void depositarValor(Long nroConta, double valor){
        if(nroConta == this.nroConta){
            this.saldo += valor;
        }
    }
    public String encerrarConta(Long nroConta){
        if(nroConta ==  this.nroConta){
            this.situacao = SituacaoEnum.INATIVA;
            this.saldo = 0;
            return "Conta encerrada";
        }else{
            return "Conta inválida";
        }
    }
    public Long abrirConta(int senha){
        nroConta = gerarNumeroConta();
        dtAbertura = LocalDate.now();
        situacao = SituacaoEnum.ATIVA;
        saldo = 100;
        this.senha = senha;
        return nroConta;
    }

    public boolean validarSenha(int senha){
        if(senha == this.senha){
            return true;
        }
        else{
            return false;
        }
    }



    public Long getNroConta() {
        return nroConta;
    }

    public void setNroConta(Long nroConta) {
        this.nroConta = nroConta;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public LocalDate getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(LocalDate dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }
}
