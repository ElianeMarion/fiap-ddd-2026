package br.com.fiap.heranca.models;
//Pessoa é a superclasse
//Generalização - Tudo que é genérico
//Sobrecarga de métodos: Método com mesmo nome e assinatura diferente
//Na herança temos a SOBRESCRITA DE MÉTODOS

//Classe abstrata -> É um modelo, mas não pode ser instanciada
public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    private String email;

    public String exibirDados(){
        return "Nome: " + nome + " - cpf: " + cpf + "\nE-mail: " + email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
