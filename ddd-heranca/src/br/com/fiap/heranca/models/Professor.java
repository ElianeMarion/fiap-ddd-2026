package br.com.fiap.heranca.models;

public class Professor extends Pessoa{

    //Especialização -> atributos específicos da classe filha
    private String ctps;
    private double valorHora;
    private double qtdHoras;

    //Sobrescrita de método, criar o mesmo método que o pai mas com implementação
    //diferente

    public String exibirDados(){
        return super.exibirDados() +
                "\nCTPS: " + ctps +
                "\nSalário do professor: " + calcularSalario();
    }
    public double calcularSalario(){
        return  valorHora * qtdHoras;
    }

    public void exibirProfessor(){
        System.out.println(nome + " cpf: " + cpf + " email: " + getEmail());
    }
    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(double qtdHoras) {
        this.qtdHoras = qtdHoras;
    }
}
