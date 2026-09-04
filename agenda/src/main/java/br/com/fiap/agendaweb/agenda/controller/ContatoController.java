package br.com.fiap.agendaweb.agenda.controller;

import br.com.fiap.agendaweb.agenda.model.Aluno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @GetMapping
    public String mensagem(){
        return "Bom dia, olá mundo!!";
    }
    @GetMapping("/{id}")
    public Aluno exibirAluno(@PathVariable int id){
        Aluno aluno = new Aluno("Eliane", 1);
        return aluno;

    }
}
