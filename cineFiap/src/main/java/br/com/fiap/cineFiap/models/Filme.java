package br.com.fiap.cineFiap.models;

import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.enums.ClassificacaoIndicativaEnum;
import br.com.fiap.cineFiap.enums.SimNaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme {
    private Integer id;
    private String nome;
    private int duracao;
    private int ano;
    private String capa;
    private String diretor;
    private String elenco;
    private String descricao;
    private double avaliacao;
    private CategoriaFilmeEnum categoria;
    private ClassificacaoIndicativaEnum classificacao;
    private SimNaoEnum emCartaz;


}
