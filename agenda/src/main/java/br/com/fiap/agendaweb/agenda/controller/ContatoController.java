package br.com.fiap.agendaweb.agenda.controller;

import br.com.fiap.agendaweb.agenda.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
   /* @GetMapping
    public String mensagem(){
        return "Bom dia, olá mundo!!";
    }*/
    @GetMapping("/{id}")
    public Aluno exibirAluno(@PathVariable int id){
        Aluno aluno = new Aluno("Eliane", id);
        return aluno;
    }
    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno){
       return aluno;
    }

    @PutMapping("/{id}")
    public Aluno alterar(@RequestBody Aluno aluno,
                         @PathVariable int id){
        Aluno a = new Aluno("Maria", id);
        a.setNome(aluno.getNome());
        return a;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        System.out.println("Registro excluido");
    }
    List<Aluno> alunos = List.of(new Aluno("Ana", 1),
            new Aluno("Eliane", 2),
            new Aluno("Maria",3));

    @GetMapping
    public List<Aluno> listar(){
        return alunos;
    }
}
