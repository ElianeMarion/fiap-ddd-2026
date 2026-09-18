package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.FilmeDAO;
import br.com.fiap.cineFiap.exceptions.FilmeNaoExisteException;
import br.com.fiap.cineFiap.models.Filme;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    private final FilmeDAO filmeDAO;

    public FilmeService() {
        this.filmeDAO = new FilmeDAO();
    }

    public Filme buscarPorId(Integer id){
        var filme =  filmeDAO.buscarPorId(id);
        return filme;
       /* if(filme.getId() == null)
            throw new FilmeNaoExisteException("Filme não encontrado");
        else*/

    }


}
