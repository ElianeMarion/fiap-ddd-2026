package br.com.fiap.heranca.models;

import br.com.fiap.heranca.enums.StatusVeiculo;
/*
* Uma classe comum/concreta ela tem método comum
* Uma classe abstrata POSSO ter métodos comuns, métodos abstratos
*
*
* */
public abstract class Veiculo {
    private String placa;
    private double nivelCombustivel;
    private StatusVeiculo status;

    //Método abstrato: Não tem código
    //                 Obrigo os filhos a implementar este método
    public abstract boolean validarAutonomia(double km);
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
