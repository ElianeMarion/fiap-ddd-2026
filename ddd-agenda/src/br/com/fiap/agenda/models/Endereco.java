package br.com.fiap.agenda.models;

public class Endereco {
    private int codigo;
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private String numero;
    private String complemento;

    @Override
    public String toString() {
        return "Endereco:" +
                "codigo: " + codigo +
                ", rua: " + rua +
                ", cep:" + cep +
                ", bairro: " + bairro +
                ", cidade: " + cidade +
                ", estado: " + estado +
                ", uf: " + uf +
                ", numero: " + numero +
                 complemento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
