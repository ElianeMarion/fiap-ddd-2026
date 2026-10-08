package br.com.fiap.cineFiap.dto;

import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.enums.ClassificacaoIndicativaEnum;
import br.com.fiap.cineFiap.enums.SimNaoEnum;

public record FilmeRequest(Integer id, String nome, int duracao, int ano, String capa, String diretor,
                           String elenco, String descricao, double avaliacao, CategoriaFilmeEnum categoria,
                           ClassificacaoIndicativaEnum classificacao, SimNaoEnum emCartaz) {
}
