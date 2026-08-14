package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Classe responsável pelo CRUD de contato
public class ContatoDAO {
    private Connection conexao;

    public void cadastrar(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into tbl_contato (ID_CONTATO,NOME_CONTATO," +
                    "CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO)" +
                    "values(?, ?,?,?,?, ?);";
        }
    }
}
