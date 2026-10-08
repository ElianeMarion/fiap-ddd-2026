package br.com.fiap.cineFiap.dto;

import java.time.LocalDateTime;

public record SalaRequestCadastroDto(String nome,
                                     double preco,
                                     LocalDateTime dataExclusao) {
}
