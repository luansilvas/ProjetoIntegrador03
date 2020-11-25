package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.servlet.ServletBD;
import java.util.logging.Level;
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
import javax.swing.JOptionPane;

/**
 *
 * @author luans
 */
public class ProdutoDAO {

    public static List<ProdutoUnidade> getProdutos() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<ProdutoUnidade> listaProdutos = new ArrayList();
        try {

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select * from produto where status=1 and quantidade>0");

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                ProdutoUnidade prod = new ProdutoUnidade();
                prod.setCodProduto(rs.getInt("codProduto"));
                prod.setTitulo(rs.getString("titulo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getDouble("valor"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                prod.setStatus(rs.getInt("status"));

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

    public static List<ProdutoUnidade> getProdutos(int codUnidade) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<ProdutoUnidade> listaProdutos = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select * from produto where status=1 and quantidade>0 and Unidade_codUnidade=?");
            instrucaoSQL.setInt(1, codUnidade);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                ProdutoUnidade prod = new ProdutoUnidade();
                prod.setCodProduto(rs.getInt("codProduto"));
                prod.setTitulo(rs.getString("titulo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getDouble("valor"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                prod.setStatus(rs.getInt("status"));

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

    public static List<ProdutoUnidade> getProdutos(String categoria) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<ProdutoUnidade> listaProdutos = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select * from produto where status=1 and categoria=?");
            instrucaoSQL.setString(1, categoria);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                ProdutoUnidade prod = new ProdutoUnidade();
                prod.setCodProduto(rs.getInt("codProduto"));
                prod.setTitulo(rs.getString("titulo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getDouble("valor"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                prod.setStatus(rs.getInt("status"));

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
    public static List<ProdutoUnidade> getProdutos(String categoria,int codUnidade) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<ProdutoUnidade> listaProdutos = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select * from produto where status=1 and categoria=? and Unidade_codUnidade=?");
            instrucaoSQL.setString(1, categoria);
            instrucaoSQL.setInt(2, codUnidade);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                ProdutoUnidade prod = new ProdutoUnidade();
                prod.setCodProduto(rs.getInt("codProduto"));
                prod.setTitulo(rs.getString("titulo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getDouble("valor"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                prod.setStatus(rs.getInt("status"));

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

    public static boolean addProduto(ProdutoUnidade prod) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into produto(titulo,categoria,descricao,valor,quantidade,Unidade_codUnidade,status) values(?,?,?,?,?,?,1);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, prod.getTitulo());
            instrucaoSQL.setString(2, prod.getCategoria());
            instrucaoSQL.setString(3, prod.getDescricao());
            instrucaoSQL.setDouble(4, prod.getValor());
            instrucaoSQL.setInt(5, prod.getQuantidade());
            instrucaoSQL.setInt(6, prod.getCodUnidade());
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

    public static boolean updateProduto(ProdutoUnidade prod) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update produto set titulo=?,categoria=?,descricao=?,valor=?,quantidade=?,Unidade_codUnidade=? where codProduto=?;");

            instrucaoSQL.setString(1, prod.getTitulo());
            instrucaoSQL.setString(2, prod.getCategoria());
            instrucaoSQL.setString(3, prod.getDescricao());
            instrucaoSQL.setDouble(4, prod.getValor());
            instrucaoSQL.setInt(5, prod.getQuantidade());
            instrucaoSQL.setInt(6, prod.getCodUnidade());
            instrucaoSQL.setInt(7, prod.getCodProduto());
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

    public static boolean deleteProduto(ProdutoUnidade prod) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update produto set status = 0 where codProduto=?;");

            instrucaoSQL.setInt(1, prod.getCodProduto());
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

    public static boolean reduzEstoque(int codProduto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update produto set quantidade = quantidade-1 where codProduto=?;");

            instrucaoSQL.setInt(1, codProduto);
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

    public static boolean aumentaEstoque(int codProduto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update produto set quantidade = quantidade+1 where codProduto=?;");

            instrucaoSQL.setInt(1, codProduto);
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

    public static ProdutoUnidade getProduto(int codProduto) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ProdutoUnidade prod = new ProdutoUnidade();

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from produto where codProduto = ? and status=1;");
            instrucaoSQL.setInt(1, codProduto);

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                prod.setCodProduto(rs.getInt("codProduto"));
                prod.setTitulo(rs.getString("titulo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getDouble("valor"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                prod.setStatus(rs.getInt("status"));
                switch (prod.getCodUnidade()) {
                    case 1:
                        prod.setNomeUnidade("Matriz");
                        break;
                    case 2:
                        prod.setNomeUnidade("Campina Grande");
                        break;
                    case 3:
                        prod.setNomeUnidade("Brasília");
                        break;
                    case 4:
                        prod.setNomeUnidade("Joinville");
                }
                //String foto = rs.getString("foto");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;
    }

}
