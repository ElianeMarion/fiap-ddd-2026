package br.com.fiap.heranca.models;

public class Van extends Veiculo{
    private boolean refrigerada;

    public boolean isRefrigerada() {
        return refrigerada;
    }

    public void setRefrigerada(boolean refrigerada) {
        this.refrigerada = refrigerada;
    }

    @Override
    public boolean validarAutonomia(double km) {
        return getNivelCombustivel() >= km;
    }
}
