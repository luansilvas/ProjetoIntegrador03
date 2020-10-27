/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;


import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Unidade;
import br.senac.sp.entidade.Vendas;
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
 * @author eduardo
 */
public class VendasDAO {
    
    public static List<Vendas> getVendas() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        List<Vendas> Vendas = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = DriverManager.getConnection(URL, "root", "");

            instrucaoSQL = conexao.prepareStatement("select * from vendas where status=1");

            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Vendas vend = new Vendas();
                vend.setCodVendas(rs.getInt("codVendas"));
                vend.setDiahora(rs.getTime("diahora"));
                vend.setTotal(rs.getDouble("total"));
                
                
                Vendas.add(vend);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Vendas;
    }
    
    
    public static boolean addVenda(Vendas vend) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into produto(diahora,total,Cliente_codCliente,Unidade_codUnidade) values(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setTime(1, vend.getDiahora());
            instrucaoSQL.setDouble(2, vend.getTotal());
            //instrucaoSQL.setInt(3, vend.getCodCliente());
           // instrucaoSQL.setInt(4, vend.getCodUnidade());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    vend.setCodVendas(generatedKeys.getInt(1));


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
    
    
}
