package br.com.fiap.agenda_web.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
