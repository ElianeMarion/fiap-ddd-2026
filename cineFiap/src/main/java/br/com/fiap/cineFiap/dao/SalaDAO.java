package br.com.fiap.cineFiap.dao;

import br.com.fiap.cineFiap.models.Sala;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {

    private Connection conexao;

    public void cadastrar(Sala sala){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "insert into TBL_SALA (TX_NOME, NR_PRECO)" +
                    "values(?, ?)";

            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, sala.getNome());
            comandoSql.setDouble(2, sala.getPreco());

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sala> listar(){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Sala> salas = new ArrayList<>();

        try {
            ps = conexao.prepareStatement("select * from TBL_SALA");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Sala sala = new Sala();

                sala.setId(rs.getLong(1));
                sala.setNome(rs.getString(2));
                sala.setPreco(rs.getDouble(3));
                Timestamp timestamp = rs.getTimestamp(4);

                if (timestamp != null) {
                    sala.setDataExclusao(timestamp.toLocalDateTime());
                } else {
                    sala.setDataExclusao(null);
                }

                salas.add(sala);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salas;
    }

    public Sala buscarPorId(Long id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Sala sala = new Sala();

        try {
            ps = conexao.prepareStatement("select * from TBL_SALA where ID_SALA = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                sala.setId(rs.getLong(1));
                sala.setNome(rs.getString(2));
                sala.setPreco(rs.getDouble(3));
                Timestamp timestamp = rs.getTimestamp(4);

                if (timestamp != null) {
                    sala.setDataExclusao(timestamp.toLocalDateTime());
                } else {
                    sala.setDataExclusao(null);
                }
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }
    public void alterar(Sala sala){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "update TBL_SALA set TX_NOME = ?, NR_PRECO = ?, DT_EXCLUSAO = ? where ID_SALA = ?";

            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, sala.getNome());
            comandoSql.setDouble(2, sala.getPreco());
            if (sala.getDataExclusao() != null) {
                comandoSql.setTimestamp(3,
                        Timestamp.valueOf(sala.getDataExclusao())
                );
            } else {
                comandoSql.setNull(3, java.sql.Types.TIMESTAMP);
            }
            comandoSql.setLong(4, sala.getId());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "delete from TBL_SALA where ID_SALA = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setLong(1, id);

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Long id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "update TBL_SALA set DT_EXCLUSAO = ? where ID_SALA = ?";

            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setLong(2, id);
            comandoSql.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
