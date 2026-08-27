package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    //CRUD de endereço
    private Connection conexao;
    /*insert into endereco(codigo, cep, rua, complemento, bairro, cidade, uf)
        values(1,"01310914","AV. PAULISTA", "4 ANDAR","BELA VISTA","SÃO PAULO", "SP"*/
    public void inserir(Endereco endereco)  {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into endereco_agenda(codigo, logradouro, cep, " +
                    "bairro, cidade, estado, uf, numero, complemento)" +
                    " VALUES (?,?,?,?,?,?,?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, endereco.getCodigo());
            comandoSql.setString(2, endereco.getRua()); //rua
            comandoSql.setString(3, endereco.getCep());
            comandoSql.setString(4, endereco.getBairro());
            comandoSql.setString(5, endereco.getCidade()); //cidade
            comandoSql.setString(6, endereco.getUf());
            comandoSql.setString(7, endereco.getNumero());
            comandoSql.setString(8, endereco.getComplemento());

            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Endereco endereco)  {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("update endereco_agenda set cep = ?, logradouro = ?, complemento = ?, " +
                    "bairro = ?, cidade = ?, uf = ?, numero = ? where codigo = ?");
            comandoSql.setString(1, endereco.getCep());
            comandoSql.setString(2, endereco.getRua()); //rua
            comandoSql.setString(3, endereco.getComplemento());
            comandoSql.setString(4, endereco.getBairro());
            comandoSql.setString(5, endereco.getCidade()); //cidade
            comandoSql.setString(6, endereco.getUf());
            comandoSql.setString(7, endereco.getNumero());
            comandoSql.setInt(8, endereco.getCodigo());
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void excluir(Integer id)  {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("delete from endereco_agenda where codigo = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarPorId(Integer id){
        conexao = ConnectionFactory.obterConexao();
        Endereco endereco = new Endereco();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from endereco_agenda where codigo = ?");
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                endereco.setCodigo((rs.getInt(1)));
                endereco.setRua(rs.getString(2));
                endereco.setCep(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCidade(rs.getString(5));
                endereco.setEstado(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
                endereco.setComplemento(rs.getString(9));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return endereco;
    }

    public List<Endereco> buscarTodosEnderecos(){
        conexao = ConnectionFactory.obterConexao();
        List<Endereco> enderecos = new ArrayList<>();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from endereco_agenda ");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setCodigo((rs.getInt(1)));
                endereco.setRua(rs.getString(2));
                endereco.setCep(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCidade(rs.getString(5));
                endereco.setEstado(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
                endereco.setComplemento(rs.getString(9));

                enderecos.add(endereco);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return enderecos;
    }

}
