package br.com.fiap.agenda_web.dto;

import br.com.fiap.agenda_web.enums.TipoEnum;
import br.com.fiap.agenda_web.models.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequestDTO {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private String instagram;
    private TipoEnum tipo;
    private Endereco endereco;
}
