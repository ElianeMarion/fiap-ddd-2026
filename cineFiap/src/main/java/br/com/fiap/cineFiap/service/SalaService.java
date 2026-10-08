package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.SalaDAO;
import br.com.fiap.cineFiap.dto.SalaRequestCadastroDto;
import br.com.fiap.cineFiap.dto.SalaRequestDto;
import br.com.fiap.cineFiap.dto.SalaResponseDto;
import br.com.fiap.cineFiap.mapper.FilmeMapper;
import br.com.fiap.cineFiap.mapper.SalaMapper;
import br.com.fiap.cineFiap.models.Sala;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaService {
    private final SalaDAO salaDAO;

    public SalaService() {
        this.salaDAO = new SalaDAO();
    }

    public SalaResponseDto buscarPorId(Long id){
        var sala =  salaDAO.buscarPorId(id);
        if(sala.getId() != null)
            return SalaMapper.toRecordDTO(sala);
        throw new IllegalArgumentException("Sala não encontrada");

    }

    public List<SalaResponseDto> listar(){
        var lista = salaDAO.listar()
                .stream()
                .map(SalaMapper::toRecordDTO)
                .toList();
        return lista;
    }

    public void cadastrar(SalaRequestCadastroDto sala){
        if (sala.preco() <= 0){
            System.out.println("ERRO: Preço deve ser maior que zero.");
            throw new IllegalArgumentException(
                    "Preço deve ser maior que zero.");
        }
        if (sala.nome() == null || sala.nome().equals("")) {
            System.out.println("ERRO: Nome é obrigatório");
            throw new IllegalArgumentException(
                    "Nome é obrigatório."
            );
        }
        if (sala.dataExclusao() != null ) {
            System.out.println("ERRO: Sala não cadastrada");
            throw new IllegalArgumentException("Sala não cadastrada.");
        }
        salaDAO.cadastrar(SalaMapper.dtoCadastoToEntity(sala));
    }

    public void excluir(Long id){
        var sala = salaDAO.buscarPorId(id);
        if(sala.getId().equals(id)){
            salaDAO.deletar(id);
        }
        else
            throw new IllegalArgumentException("Sala não encontrado");
    }

    public void alterar(SalaRequestDto sala, Long id){
        var novaSala = buscarPorId(id);
        if (!novaSala.id().equals(sala.id()) || sala.id() != id){
            System.out.println("ERRO: O id informado está incorreto.");
            throw new IllegalArgumentException(
                    "O id informado está incorreto.");
        }
        if (sala.dataExclusao() != null ) {
            System.out.println("ERRO: Sala não cadastrada");
            throw new IllegalArgumentException("Sala não cadastrada.");
        }
        salaDAO.alterar(SalaMapper.dtoToEntity(sala));
    }
}
