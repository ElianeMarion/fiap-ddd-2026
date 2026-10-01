package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.dto.ContatoRequestDTO;
import br.com.fiap.agenda_web.dto.ContatoResponseDTO;
import br.com.fiap.agenda_web.mapper.ContatoMapper;
import br.com.fiap.agenda_web.models.Contato;
import br.com.fiap.agenda_web.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private ContatoService contatoService = new ContatoService();

    @GetMapping
    public List<ContatoResponseDTO> listar(){
        return contatoService.listar()
                .stream()
                .map(ContatoMapper::toDTO)
                .toList();
    }
    @GetMapping("/{id}")
    public ContatoResponseDTO buscarPorId(@PathVariable int id){
        var contato = contatoService.buscarPorId(id);
        return ContatoMapper.toDTO(contato);
    }
    @PostMapping
    public void cadastrar(@RequestBody ContatoRequestDTO dto){
        Contato contato = ContatoMapper.toEntity(dto);
        contatoService.cadastrar(contato);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody ContatoRequestDTO dto){
        Contato contato = ContatoMapper.toEntity(dto);
        contatoService.atualizar(id, contato);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        contatoService.excluir(id);
    }
}
