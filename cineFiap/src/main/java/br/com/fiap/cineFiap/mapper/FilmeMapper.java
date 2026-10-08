package br.com.fiap.cineFiap.mapper;

import br.com.fiap.cineFiap.dto.*;
import br.com.fiap.cineFiap.models.Filme;

public class FilmeMapper {

    //Convertendo para classe Dto
    public static Filme toEntity(FilmeRequestDTO dto){
        Filme filme = new Filme();
        filme.setId(dto.getId());
        filme.setNome(dto.getNome());
        filme.setDuracao(dto.getDuracao());
        filme.setAno(dto.getAno());
        filme.setCapa(dto.getCapa());
        filme.setDiretor(dto.getDiretor());
        filme.setElenco(dto.getElenco());
        filme.setDescricao(dto.getDescricao());
        filme.setAvaliacao(dto.getAvaliacao());
        filme.setCategoria(dto.getCategoria());
        filme.setClassificacao(dto.getClassificacao());
        filme.setEmCartaz(dto.getEmCartaz());
        return filme;
    }

    public static FilmeResponseDTO toDTO(Filme filme){
        FilmeResponseDTO dto = new FilmeResponseDTO();
        dto.setId(filme.getId());
        dto.setNome(filme.getNome());
        dto.setDuracao(filme.getDuracao());
        dto.setAno(filme.getAno());
        dto.setCapa(filme.getCapa());
        dto.setDiretor(filme.getDiretor());
        dto.setElenco(filme.getElenco());
        dto.setDescricao(filme.getDescricao());
        dto.setAvaliacao(filme.getAvaliacao());
        dto.setCategoria(filme.getCategoria());
        dto.setClassificacao(filme.getClassificacao());
        dto.setEmCartaz(filme.getEmCartaz());
        return dto;

    }
    //Convertendo para record Dto
    public static Filme dtoToEntity(FilmeRequest dto){
        Filme filme = new Filme();
        filme.setId(dto.id());
        filme.setNome(dto.nome());
        filme.setDuracao(dto.duracao());
        filme.setAno(dto.ano());
        filme.setCapa(dto.capa());
        filme.setDiretor(dto.diretor());
        filme.setElenco(dto.elenco());
        filme.setDescricao(dto.descricao());
        filme.setAvaliacao(dto.avaliacao());
        filme.setCategoria(dto.categoria());
        filme.setClassificacao(dto.classificacao());
        filme.setEmCartaz(dto.emCartaz());
        return filme;
    }
    public static FilmeResponse toRecordDTO(Filme filme){
        FilmeResponse dto = new FilmeResponse(
        filme.getId(),
        filme.getNome(),
        filme.getDuracao(),
        filme.getAno(),
        filme.getCapa(),
        filme.getDiretor(),
        filme.getElenco(),
        filme.getDescricao(),
        filme.getAvaliacao(),
        filme.getCategoria(),
        filme.getClassificacao(),
        filme.getEmCartaz());
        return dto;
    }
    public static FilmeResponseCardsDto toCardDTO(Filme filme){
        FilmeResponseCardsDto dto = new FilmeResponseCardsDto(
                filme.getId(),
                filme.getNome(),
                filme.getDuracao(),
                filme.getCapa());
        return dto;
    }

}
