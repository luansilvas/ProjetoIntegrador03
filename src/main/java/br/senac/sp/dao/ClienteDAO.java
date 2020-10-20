/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.entidade.Cliente;
import br.senac.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ClienteDAO {

    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";
            conexao = DriverManager.getConnection(URL, "root", "");
            instrucaoSQL = conexao.prepareStatement("select * from produto where status=1");
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                listaClientes.add(new Cliente(nome, cpf, email));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }
    
    
}
