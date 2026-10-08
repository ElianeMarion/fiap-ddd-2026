package br.com.fiap.cineFiap.controller;

import br.com.fiap.cineFiap.dao.SalaDAO;
import br.com.fiap.cineFiap.dto.SalaRequestCadastroDto;
import br.com.fiap.cineFiap.dto.SalaRequestDto;
import br.com.fiap.cineFiap.dto.SalaResponseDto;
import br.com.fiap.cineFiap.service.SalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*") //@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/salas")
public class SalaController {
    private SalaService service = new SalaService();

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody SalaRequestCadastroDto sala){
        try{
            service.cadastrar(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sala cadastrada com sucesso!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar a sala: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDto> buscarPorId(@PathVariable Long id){
        try {
            var sala = service.buscarPorId(id);
            return ResponseEntity.ok(sala);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping
    public ResponseEntity<List<SalaResponseDto>> listar(){

        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        try{
            service.excluir(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@PathVariable Long id,
                                        @RequestBody SalaRequestDto objeto){
        try {
            service.alterar(objeto, id);
            return ResponseEntity.ok().build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/excluir/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        try{
            service.excluir(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
