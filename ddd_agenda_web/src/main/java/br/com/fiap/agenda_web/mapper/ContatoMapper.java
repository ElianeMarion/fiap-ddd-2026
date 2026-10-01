package br.com.fiap.agenda_web.mapper;

import br.com.fiap.agenda_web.dto.ContatoRequestDTO;
import br.com.fiap.agenda_web.dto.ContatoResponseDTO;
import br.com.fiap.agenda_web.models.Contato;

//Responsável pelas conversões objeto -> DTO e DTO -> objeto
public class ContatoMapper {
    public static Contato toEntity (ContatoRequestDTO dto){
        Contato contato = new Contato();
        contato.setId(dto.getId());
        contato.setNome(dto.getNome());
        contato.setEmail(dto.getEmail());
        contato.setInstagram(dto.getInstagram());
        contato.setTipo(dto.getTipo());
        contato.setEndereco(dto.getEndereco());
        return contato;
    }

    public static ContatoResponseDTO toDTO(Contato contato){
        ContatoResponseDTO dto = new ContatoResponseDTO();
        dto.setId(contato.getId());
        dto.setNome(contato.getNome());
        dto.setCelular(contato.getCelular());
        dto.setEmail(contato.getEmail());
        dto.setInstagram(contato.getInstagram());
        dto.setTipo(contato.getTipo());
        dto.setEndereco(contato.getEndereco());
        return dto;
    }
}
