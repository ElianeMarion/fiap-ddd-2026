package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.FilmeDAO;
import br.com.fiap.cineFiap.models.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeDAO filmeDAO;

    public FilmeService() {
        this.filmeDAO = new FilmeDAO();
    }

    public Filme buscarPorId(Integer id){
        var filme =  filmeDAO.buscarPorId(id);
        return filme;

    }

    public List<Filme> filmeEmCartaz(){
        return filmeDAO.buscarEmCartaz();
    }

    public void cadastrar(Filme filme){
        if (filme.getDuracao() <= 0){
            System.out.println("ERRO: A duração deve ser maior que zero.");
            throw new IllegalArgumentException(
                    "A duração deve ser maior que zero.");
        }
        if (filme.getClassificacao() == null ) {
            System.out.println("ERRO: A classificação indicativa é obrigatória");
            throw new IllegalArgumentException(
                    "A classificação indicativa é obrigatória."
            );
        }
        if (filme.getCategoria() == null ) {
            System.out.println("ERRO: A categoria é obrigatória");
            throw new IllegalArgumentException("A categoria é obrigatória.");
        }
        filmeDAO.cadastrar(filme);
    }

    public void excluir(Integer id){
        var filme = filmeDAO.buscarPorId(id);
        if(filme.getId() == id){
            filmeDAO.excluir(id);
        }
        else
            throw new IllegalArgumentException("Filme não encontrado");
    }

    public void alterar(Filme filme){
        filmeDAO.alterar(filme);
    }

}
