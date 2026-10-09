package br.com.fiap.agenda_web.service;


import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoDAO enderecoDAO;
    private final ViaCepService viaCepService;

    public EnderecoService(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
        enderecoDAO = new EnderecoDAO();
    }

    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }

    public Endereco consultarCep(String cep){
        var enderecoDto = viaCepService.consultarCep(cep);
        var endereco = new Endereco();
        endereco.setCep(enderecoDto.cep());
        endereco.setUf(enderecoDto.uf());
        endereco.setBairro(enderecoDto.bairro());
        endereco.setRua(enderecoDto.logradouro());
        endereco.setCidade(enderecoDto.localidade());
        endereco.setEstado(enderecoDto.estado());
        return endereco;
    }
    public Endereco buscarPorId(int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }
    public void cadastrar( Endereco endereco){
        if(endereco.getCep() != null ) {
            var novoEndereco = consultarCep(endereco.getCep());
            novoEndereco.setNumero(endereco.getNumero());
            novoEndereco.setComplemento(endereco.getComplemento());
            novoEndereco.setCodigo(endereco.getCodigo());
            enderecoDAO.inserir(novoEndereco);
        }else
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
