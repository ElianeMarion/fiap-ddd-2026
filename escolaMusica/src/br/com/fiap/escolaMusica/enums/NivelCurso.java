package br.com.fiap.escolaMusica.enums;


/**
 * Enumeração que define os níveis de aprendizado para os cursos de música.
 * Conforme as convenções solicitadas, os elementos do Enum estão declarados em letras maiúsculas.
 */
public enum NivelCurso {
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private final String descricao;

    /**
     * Construtor do Enum para inicializar a descrição legível do nível.
     *
     * @param descricao Texto formatado que descreve o nível
     */
    NivelCurso(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição legível do nível.
     *
     * @return String contendo a descrição
     */
    public String getDescricao() {
        return descricao;
    }
}

