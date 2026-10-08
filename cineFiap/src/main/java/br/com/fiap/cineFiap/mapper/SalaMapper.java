package br.com.fiap.cineFiap.mapper;

import br.com.fiap.cineFiap.dto.SalaRequestCadastroDto;
import br.com.fiap.cineFiap.dto.SalaRequestDto;
import br.com.fiap.cineFiap.dto.SalaResponseDto;
import br.com.fiap.cineFiap.models.Sala;

public class SalaMapper {
    //recebendo um dto converter para entity(modelagem)
    public static Sala dtoToEntity(SalaRequestDto dto){
        Sala sala = new Sala();
        sala.setId(dto.id());
        sala.setNome(dto.nome());
        sala.setPreco(dto.preco());
        sala.setDataExclusao(dto.dataExclusao());
        return sala;
    }

    public static Sala dtoCadastoToEntity(SalaRequestCadastroDto dto){
        Sala sala = new Sala();
        sala.setNome(dto.nome());
        sala.setPreco(dto.preco());
        sala.setDataExclusao(dto.dataExclusao());
        return sala;
    }

    //salaToDto
    public static SalaResponseDto toRecordDTO(Sala sala){
        SalaResponseDto dto = new SalaResponseDto(
                sala.getId(),
                sala.getNome(),
                sala.getPreco(),
                sala.getDataExclusao());
        return dto;
    }
}
