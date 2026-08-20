package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Classe responsável pelo CRUD de contato
public class ContatoDAO {
    private Connection conexao;
    //CRUD -> Create (cadastro) : SQL: insert
    public void cadastrar(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into tbl_contato (ID_CONTATO,NOME_CONTATO," +
                    "CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO)" +
                    "values(?, ?,?,?,?, ?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, contato.getId());
            comandoSql.setString(2, contato.getNome());
            comandoSql.setString(3, contato.getCelular());
            comandoSql.setString(4, contato.getEmail());
            comandoSql.setString(5, contato.getInstagram());
            comandoSql.setString(6, contato.getTipo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //CRUD - R: READ - SQL: SELECT
    public Contato buscarPorId(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();
        try{
            ps = conexao.prepareStatement("select * from TBL_CONTATO where ID_CONTATO = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(rs.getString(6));
            }
            ps.close();
            conexao.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contato;
    }
}
