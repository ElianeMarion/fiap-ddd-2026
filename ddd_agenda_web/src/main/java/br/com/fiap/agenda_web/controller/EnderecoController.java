package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import br.com.fiap.agenda_web.service.EnderecoService;
import br.com.fiap.agenda_web.service.ViaCepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private ViaCepService viaCepService = new ViaCepService();
    private EnderecoService enderecoService = new EnderecoService(viaCepService);


    @GetMapping
    public List<Endereco> listar(){
        return enderecoService.listar();
    }

    @GetMapping("cep/{cep}")
    public Endereco consultarCep(@PathVariable String cep){
        var endereco = enderecoService.consultarCep(cep);
        return endereco;
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable int id){
        var endereco = enderecoService.buscarPorId(id);
        return endereco;
    }
    @PostMapping
    public void cadastrar(@RequestBody Endereco endereco){
        enderecoService.cadastrar(endereco);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody Endereco endereco){
        enderecoService.atualizar(id, endereco);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        enderecoService.excluir(id);
    }



}
