package br.com.fiap.cineFiap.resource;

import br.com.fiap.cineFiap.models.Filme;
import br.com.fiap.cineFiap.service.FilmeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService service;

    public FilmeController() {
        this.service = new FilmeService();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }
}
