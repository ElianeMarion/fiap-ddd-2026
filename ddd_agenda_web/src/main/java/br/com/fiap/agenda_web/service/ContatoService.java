package br.com.fiap.agenda_web.service;

import br.com.fiap.agenda_web.dao.ContatoDAO;
import br.com.fiap.agenda_web.models.Contato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    
    private final ContatoDAO contatoDAO;
    public ContatoService() {
        this.contatoDAO = new ContatoDAO();
    }

    public List<Contato> listar(){
        return contatoDAO.listar();
    }

    public Contato buscarPorId(int id){
        var contato = contatoDAO.buscarPorId(id);
        return contato;
    }
    public void cadastrar( Contato contato){
        if(contato.getId() != 0 )
            contatoDAO.cadastrar(contato);
        else
            throw new RuntimeException("Contato incompleto");
    }

    public void atualizar( int id, Contato contato){
        if(id != contato.getId())
            throw new IllegalArgumentException("O código do contato não corresponde ao código informado");

        Contato contatoExiste = buscarPorId(id);
        if(contatoExiste == null)
            throw new IllegalArgumentException("Contato não encontrado");

        contatoDAO.alterar(contato);
    }

    public void excluir(int id){
        Contato contatoExiste = buscarPorId(id);
        if(contatoExiste == null)
            throw new IllegalArgumentException("Contato não encontrado");

        contatoDAO.excluir(id);
    }
}
