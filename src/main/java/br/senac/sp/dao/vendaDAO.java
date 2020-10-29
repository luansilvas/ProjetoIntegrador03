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
public class vendaDAO {

    public static int newSale(double total, int codFuncionario, int codCliente, int codUnidade) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Venda v1 = new Venda();
        try {


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

    public static boolean cancelarVenda(int codVenda) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM Venda where codVenda=1");
            instrucaoSQL.setInt(1, codVenda);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

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

    public static List<Venda> getVendas() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where v.status=1");

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setTotal(rs.getDouble("produto_valor"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
public static List<Venda> getVenda() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where v.status=1 group by codVenda");

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setTotal(rs.getDouble("produto_valor"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
    public static List<Venda> getVendas(int codUnidade, String CPF, String categoria) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where categoria=? and v.unidade_codUnidade=? and cpf=? ;");
            instrucaoSQL.setString(1, categoria);
            instrucaoSQL.setInt(2, codUnidade);
            instrucaoSQL.setString(3, CPF);

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setTotal(rs.getDouble("valor"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<Venda> getVendasCategoria(int codUnidade, String categoria) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where categoria=? and v.unidade_codUnidade=? group by codVenda;");
            instrucaoSQL.setString(1, categoria);
            instrucaoSQL.setInt(2, codUnidade);


            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setTotal(rs.getDouble("valor"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
    public static List<Venda> getVendasCliente(int codUnidade, String cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where cpf=? and v.unidade_codUnidade=? group by codVenda;");
            instrucaoSQL.setString(1, cpf);
            instrucaoSQL.setInt(2, codUnidade);

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {

                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setTotal(rs.getDouble("total"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);


            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
    public static List<Venda> getVendasUnidade(int codUnidade) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Venda> listaVendas = new ArrayList();
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM VENDA v inner join cliente c on codCliente = v.cliente_codCliente inner join produtoVenda pv on pv.venda_codVenda = v.codVenda inner join produto p on p.codProduto = pv.produto_codProduto where v.unidade_codUnidade=?;");

            instrucaoSQL.setInt(1, codUnidade);

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {

                Venda venda = new Venda();
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setProduto_categoria(rs.getString("categoria"));
                venda.setTotal(rs.getDouble("total"));
                venda.setFuncionario_codFuncionario(rs.getInt("funcionario_codFuncionario"));
                venda.setCliente_codCliente(rs.getInt("cliente_codCliente"));
                venda.setCPF(rs.getString("cpf"));
                venda.setDatahora(rs.getString("datahora"));
                venda.setStatus(rs.getInt("status"));

                listaVendas.add(venda);


            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

}
