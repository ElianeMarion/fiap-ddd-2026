package br.com.fiap.agenda_web.dto;

import br.com.fiap.agenda_web.enums.TipoEnum;
import br.com.fiap.agenda_web.models.Endereco;

public record ContatoRequest(
        int id,
        String nome,
        String celular,
        String email,
        String instagram,
        TipoEnum tipo,
        Endereco endereco
) {
}
