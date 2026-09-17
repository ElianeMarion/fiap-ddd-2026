package br.com.fiap.agenda_web.service;


import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoDAO enderecoDAO;

    public EnderecoService() {
        enderecoDAO = new EnderecoDAO();
    }

    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }

    public Endereco buscarPorId(int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }
    public void cadastrar( Endereco endereco){
        if(endereco.getCep() != null )
            enderecoDAO.inserir(endereco);
        else
            throw new RuntimeException("Endereço incompleto");
    }

    public void atualizar( int id, Endereco endereco){
        if(id != endereco.getCodigo())
            throw new IllegalArgumentException("O código do endereço não corresponde ao código informado");

        Endereco enderecoExiste = buscarPorId(id);
        if(enderecoExiste == null)
            throw new IllegalArgumentException("Endereço não encontrado");

        enderecoDAO.alterar(endereco);
    }

    public void excluir(int id){
        Endereco enderecoExiste = buscarPorId(id);
        if(enderecoExiste == null)
            throw new IllegalArgumentException("Endereço não encontrado");

        enderecoDAO.excluir(id);
    }

}
