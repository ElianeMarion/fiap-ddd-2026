package br.com.fiap.cineFiap.dao;

import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.enums.ClassificacaoIndicativaEnum;
import br.com.fiap.cineFiap.enums.SimNaoEnum;
import br.com.fiap.cineFiap.models.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private Connection conexao;

    /** Cadastra um filme no banco de dados.
     * Antes de realizar a inserção, o método valida se a duração do filme
     * é maior que zero, se a classificação indicativa foi informada e se
     * a categoria do filme foi preenchida.
     * Caso alguma validação não seja atendida, uma mensagem de erro é
     * exibida no console e o cadastro não é realizado.
     * @param filme objeto  Filme contendo os dados do filme que será cadastrado
     * @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     * de dados ou durante a execução do comando SQL
     * */
    public void cadastrar(Filme filme){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "insert into tbl_filme (ID_FILME, TX_NOME, NR_DURACAO," +
                    "TP_CATEGORIA, TP_CLASSIFICACAO," +
                    "NR_ANO, TX_CAPA, TX_DIRETOR," +
                    "TX_ELENCO, TX_DESCRICAO, NR_AVALIACAO, CHK_EM_CARTAZ)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setInt(1, filme.getId());
            comandoSql.setString(2, filme.getNome());
            comandoSql.setInt(3, filme.getDuracao());
            comandoSql.setString(4, filme.getCategoria().toString());
            comandoSql.setString(5, filme.getClassificacao().toString());
            comandoSql.setInt(6, filme.getAno());
            comandoSql.setString(7, filme.getCapa());
            comandoSql.setString(8, filme.getDiretor());
            comandoSql.setString(9, filme.getElenco());
            comandoSql.setString(10, filme.getDescricao());
            comandoSql.setDouble(11, filme.getAvaliacao());
            comandoSql.setString(12, filme.getEmCartaz().toString());

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Busca filmes no banco de dados de acordo com a categoria informada.
     * Retorna uma lista contendo todos os filmes encontrados com a categoria
     * informada.
     * @param categoria categoria dos filmes que serão buscados
     * @return lista de filmes encontrados com a categoria informada
     * @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     * de dados ou durante a execução do comando SQL*/

    public List<Filme> buscarPorCategoria(String categoria) {
        conexao = ConnectionFactory.obterConexao();;
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where TP_CATEGORIA = ?");
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);

            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    /** Busca os filmes que estão em cartaz no banco de dados.
     * Retorna uma lista contendo todos os filmes que estão marcados como
     * "SIM" no campo de filmes em cartaz.
     * @return lista de filmes que estão em cartaz
     * @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     * de dados ou durante a execução do comando SQL
     * */

    public List<Filme> buscarEmCartaz(){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try {
            ps = conexao.prepareStatement("select * from TBL_FILME where CHK_EM_CARTAZ = ?");
            ps.setString(1, "S");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    /** Busca filmes no banco de dados de acordo com o nome informado.
     * Retorna uma lista contendo os filmes que possuem o nome informado.
     * @param nome nome do filme que será buscado
     * @return lista de filmes encontrados com o nome informado
     * @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     * de dados ou durante a execução do comando SQL
     * */

    public List<Filme> buscarPorNome(String nome) {

        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where TX_NOME = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    /** Busca filmes no banco de dados de acordo com o ano informado.
     *  Retorna uma lista contendo os filmes lançados no ano informado.
     *  @param ano ano de lançamento dos filmes que serão buscados
     *  @return lista de filmes encontrados com o ano informado
     *  @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     *  de dados ou durante a execução do comando SQL
     *  */
    public List<Filme> buscarPorAno(int ano) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where NR_ANO = ?");
            ps.setInt(1, ano);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    /** Busca um filme no banco de dados de acordo com o ID informado.
     *  Caso o filme seja encontrado, seus dados são retornados em um objeto Filme.
     *  Caso não seja encontrado, retorna um objeto Filme vazio.
     *  @param id ID do filme que será buscado
     *  @return filme encontrado no banco de dados
     *  @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     *  de dados ou durante a execução do comando SQL
     *  */
    public Filme buscarPorId(int id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;

        Filme filme = new Filme();
        try {
            String sql = "SELECT * FROM tbl_filme WHERE ID_FILME = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filme;
    }


    /** Altera os dados de um filme no banco de dados.
     * O filme é localizado pelo seu ID e os dados de nome, duração, categoria,
     * diretor, descrição, avaliação e status de exibição são atualizados.
     * @param filme objeto Filme contendo os novos dados do filme
     * @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     * de dados ou durante a execução do comando SQL
     * */
    public void alterar(Filme filme)  {
        conexao = ConnectionFactory.obterConexao(); PreparedStatement comandoSql = null; try { String sql = "UPDATE tbl_filme SET TX_NOME = ?, NR_DURACAO = ?, TP_CATEGORIA = ?, " +
                "TX_DIRETOR = ?, TX_DESCRICAO = ?, NR_AVALIACAO = ?, CHK_EM_CARTAZ = ? WHERE ID_FILME = ?";

        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setString(1, filme.getNome());
        comandoSql.setInt(2, filme.getDuracao());
        comandoSql.setString(3, filme.getCategoria().toString());
        comandoSql.setString(4, filme.getDiretor());
        comandoSql.setString(5, filme.getDescricao());
        comandoSql.setDouble(6, filme.getAvaliacao());
        comandoSql.setString(7, filme.getEmCartaz().toString());
        comandoSql.setInt(8, filme.getId());
        comandoSql.executeUpdate(); comandoSql.close();
        conexao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Exclui um filme do banco de dados de acordo com o ID informado.
     *  O filme é localizado pelo seu ID e removido da tabela de filmes.
     *  @param id ID do filme que será excluído
     *  @throws RuntimeException caso ocorra algum erro durante a conexão com o banco
     *  de dados ou durante a execução do comando SQL
     *  */
    public void excluir(Integer id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "DELETE FROM tbl_filme WHERE ID_FILME = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            comandoSql.executeUpdate();
            comandoSql.close(); conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}