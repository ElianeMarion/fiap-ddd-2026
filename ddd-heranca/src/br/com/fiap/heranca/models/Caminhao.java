package br.com.fiap.heranca.models;

public class Caminhao extends Veiculo{
    private double capacidadeCarga;

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public boolean validarAutonomia(double km) {
        return (getNivelCombustivel() * 2) >= km;
    }
}
