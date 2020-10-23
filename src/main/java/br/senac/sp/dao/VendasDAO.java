/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;


import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Cliente;
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
    
    
}
