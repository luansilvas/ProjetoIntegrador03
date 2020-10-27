package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luans
 */
public class vendaDAO {

    public static int newSale(double total, int codFuncionario, int codCliente, int codUnidade) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Venda v1 = new Venda();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into venda (total,funcionario_codFuncionario,cliente_codCliente,Unidade_codUnidade,datahora,status) values(?,?,?,?,now(),1);", Statement.RETURN_GENERATED_KEYS);
            instrucaoSQL.setDouble(1, total);
            instrucaoSQL.setInt(2, codFuncionario);
            instrucaoSQL.setInt(3, codCliente);
            instrucaoSQL.setInt(4, codUnidade);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    v1.setCodVenda(generatedKeys.getInt(1));

                } else {
                    throw new SQLException("Falha ao obter o código da venda.");
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

        return v1.getCodVenda();

    }

}
