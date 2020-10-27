package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.ProdutoVenda;

import br.senac.sp.entidade.Venda;
import br.senac.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luans
 */
public class ProdutoVendaDAO {

    public static boolean addProduto(ProdutoUnidade prod) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into ProdutoVenda(produto_codProduto,produto_valor,funcionario_codFuncionario,status) values(?,?,1,1);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, prod.getCodProduto());
            instrucaoSQL.setDouble(2, prod.getValor());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    prod.setCodProduto(generatedKeys.getInt(1));

                } else {
                    throw new SQLException("Falha ao obter o código do Pedido.");
                }
            } else {
                //retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            //retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    ConexaoDB.fecharConexao();
                }
            } catch (SQLException ex) {
                System.out.println("Houve erro ao encerrar sua conexão. Tente novamente.");
            }
        }

        return retorno;

    }

    public static List<ProdutoUnidade> getProdutos() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<ProdutoUnidade> listaProdutos = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = DriverManager.getConnection(URL, "root", "");

            instrucaoSQL = conexao.prepareStatement("select * from ProdutoVenda where status=1");

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                ProdutoUnidade prod = new ProdutoUnidade();
                prod.setCodProdutoVenda(rs.getInt("codProdutoVenda"));
                prod.setCodProduto(rs.getInt("produto_codProduto"));
                prod.setValor(rs.getInt("produto_valor"));
                prod.setCodFuncionario(rs.getInt("funcionario_codFuncionario"));

                //String foto = rs.getString("foto");
                listaProdutos.add(prod);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }
    
    
    
        public static boolean FecharProdutoVenda(int codVenda,int codFuncionario) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = DriverManager.getConnection(URL, "root", "");

            instrucaoSQL = conexao.prepareStatement("update produtoVenda set venda_codVenda=?,funcionario_codFuncionario=?, status = 0 where status = 1;");

            instrucaoSQL.setInt(1,codVenda);
            instrucaoSQL.setInt(2,codFuncionario);


            instrucaoSQL.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;

    }

}
