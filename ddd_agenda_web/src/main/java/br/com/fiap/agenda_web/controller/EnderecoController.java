package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    @GetMapping
    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }
    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }
    @PostMapping
    public void cadastrar(@RequestBody Endereco endereco){
        System.out.println("Entrou");
        enderecoDAO.inserir(endereco);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody Endereco endereco){
        enderecoDAO.alterar(endereco);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        enderecoDAO.excluir(id);
    }



}
