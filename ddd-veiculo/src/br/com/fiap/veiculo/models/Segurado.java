package br.com.fiap.veiculo.models;

import br.com.fiap.veiculo.interfaces.ISeguroService;

import java.time.LocalDateTime;

public class Segurado extends Veiculo implements ISeguroService {

    private double seguro;

    public Segurado(double seguro) {
        this.seguro = seguro;
    }
    @Override
    public double doTotal(){
        return  super.doTotal() - doDesconto();
    }


    public String doViewCupom(){
        return super.doViewCupom()
                + "\nDesconto: " + doDesconto() +
                "\nValor Total R$ " + doTotal();
    }

    @Override
    public double doDesconto() {
        return super.doTotal() * seguro / 100;
    }
}
