package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.models.Contato;
import br.com.fiap.agenda_web.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private ContatoService contatoService = new ContatoService();

    @GetMapping
    public List<Contato> listar(){
        return contatoService.listar();
    }
    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable int id){
        var contato = contatoService.buscarPorId(id);
        return contato;
    }
    @PostMapping
    public void cadastrar(@RequestBody Contato contato){
        contatoService.cadastrar(contato);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody Contato contato){
        contatoService.atualizar(id, contato);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        contatoService.excluir(id);
    }



}
