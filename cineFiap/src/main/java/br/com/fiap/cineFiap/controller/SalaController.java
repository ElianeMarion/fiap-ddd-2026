package br.com.fiap.cineFiap.controller;

import br.com.fiap.cineFiap.dao.SalaDAO;
import br.com.fiap.cineFiap.models.Sala;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/salas")
public class SalaController {
    private SalaDAO dao = new SalaDAO();

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Sala sala){
        try{
            dao.cadastrar(sala);

            return ResponseEntity.status(HttpStatus.CREATED).body("Sala cadastrada com sucesso!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar a sala: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id){
        var sala = dao.buscarPorId(id);
        if(sala.getId() != null)
            return ResponseEntity.ok(sala);
        return ResponseEntity.notFound().build();

    }
    @GetMapping
    public ResponseEntity<List<Sala>> salasEmCartaz(){
        return ResponseEntity.ok(dao.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        try{
            dao.excluir(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@PathVariable Long id,
                                        @RequestBody Sala objeto){
        var filme = dao.buscarPorId(id);
        if(Objects.equals(filme.getId(), objeto.getId())) {
            dao.alterar(objeto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/excluir/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        var filme = dao.buscarPorId(id);
        if(Objects.equals(filme.getId(), id)) {
            dao.deletar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
