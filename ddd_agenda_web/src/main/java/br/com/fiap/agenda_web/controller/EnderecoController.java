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

}
