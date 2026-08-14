package br.com.fiap.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection obterConexao(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "pf1551", "fiap26");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}
