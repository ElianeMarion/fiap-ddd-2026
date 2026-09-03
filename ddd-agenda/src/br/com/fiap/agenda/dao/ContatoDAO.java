package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;
import br.com.fiap.agenda.models.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe responsável pelo CRUD de contato
public class ContatoDAO {
    private Connection conexao;
    //CRUD -> Create (cadastro) : SQL: insert
    //codigo se refere ao código do endereço
    public void cadastrar(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into tbl_contato (ID_CONTATO,NOME_CONTATO," +
                    "CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO, CODIGO)" +
                    "values(?, ?,?,?,?, ?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, contato.getId());
            comandoSql.setString(2, contato.getNome());
            comandoSql.setString(3, contato.getCelular());
            comandoSql.setString(4, contato.getEmail());
            comandoSql.setString(5, contato.getInstagram());
            comandoSql.setString(6, contato.getTipo());
            comandoSql.setInt(7, contato.getEndereco().getCodigo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cadastrarContatoEnderecoEntrega (Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try {
            conexao.setAutoCommit(false); //transação
            String sql = "insert into tbl_contato (ID_CONTATO,NOME_CONTATO," +
                    "CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO, CODIGO)" +
                    "values(?, ?,?,?,?, ?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, contato.getId());
            comandoSql.setString(2, contato.getNome());
            comandoSql.setString(3, contato.getCelular());
            comandoSql.setString(4, contato.getEmail());
            comandoSql.setString(5, contato.getInstagram());
            comandoSql.setString(6, contato.getTipo());
            comandoSql.setInt(7, contato.getEndereco().getCodigo());
            comandoSql.executeUpdate();
            comandoSql.close();

            //Inserir os endereços de entrega
            if (contato.getEnderecosEntrega() != null) {
                for (Endereco endereco : contato.getEnderecosEntrega()) {
                    PreparedStatement psEntrega = conexao.prepareStatement("INSERT INTO tbl_contato_endereco_entrega" +
                            "(id_contato, id_endereco) values ( ?, ? )");
                    psEntrega.setInt(1, contato.getId());
                    psEntrega.setInt(2, endereco.getCodigo());
                    psEntrega.executeUpdate();
                    psEntrega.close();
                }
            }
            conexao.commit(); //Confirma a transação
        }catch (SQLException e){
            try{
                conexao.rollback(); //desfaz a transação em caso de erro
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace(); //Erros comuns
        } finally {
            try{
                if(conexao != null && !conexao.isClosed())
                    conexao.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //CRUD - R: READ - SQL: SELECT
    public Contato buscarPorId(int id){

        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
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
                int codigo = rs.getInt(7);
                Endereco endereco = new Endereco();
                endereco = enderecoDAO.buscarPorId(codigo);
                contato.setEndereco(endereco);

            }
            ps.close();
            conexao.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contato;
    }

    //Método buscarPorIdAtualizado -> buscar o contato e trazer a lista de endereços de entrega
    public Contato buscarPorIdAtualizado(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        try{
            ps = conexao.prepareStatement("Select * from tbl_contato where id_contato = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(rs.getString(6));
                int codigoEnderecoPrincipal = rs.getInt(7);
                Endereco endereco = new Endereco();
                endereco = enderecoDAO.buscarPorId(codigoEnderecoPrincipal);
                contato.setEndereco(endereco);

                //buscar endereços de entrega (N:N)
                PreparedStatement psEntrega = conexao.prepareStatement("select id_endereco from " +
                        "tbl_contato_endereco_entrega where id_contato = ?");
                psEntrega.setInt(1, id);
                ResultSet rsEntrega = psEntrega.executeQuery();
                List<Endereco> enderecosEntrega = new ArrayList<>();
                while (rsEntrega.next()){
                    Endereco enderecoEntrega = enderecoDAO.buscarPorId(rsEntrega.getInt(1));
                    enderecosEntrega.add(enderecoEntrega);
                }
                contato.setEnderecosEntrega(enderecosEntrega);
                rsEntrega.close();
                psEntrega.close();
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            try{
                if(conexao != null && !conexao.isClosed())
                    conexao.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return contato;
    }

    public void alterar(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE TBL_CONTATO SET NOME_CONTATO = ?, " +
                    "CELULAR_CONTATO = ?, EMAIL_CONTATO = ?, " +
                    "INSTAGRAM = ?, TIPO = ? WHERE ID_CONTATO = ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getCelular());
            ps.setString(3, contato.getEmail());
            ps.setString(4, contato.getInstagram());
            ps.setString(5, contato.getTipo());
            ps.setInt(6, contato.getId());
            ps.executeUpdate();
            ps.close();
            conexao.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement("DELETE FROM TBL_CONTATO " +
                    " WHERE ID_CONTATO = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexao.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Contato> listar(){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Contato> contatos = new ArrayList<>();
        try{
            ps = conexao.prepareStatement("select * from TBL_CONTATO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contato c = new Contato();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setCelular(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setInstagram(rs.getString(5));
                c.setTipo(rs.getString(6));
                contatos.add(c);
            }
            ps.close();
            conexao.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contatos;
    }
}
