/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Cliente;
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
 * @author Gustavo
 */
public class ClienteDAO {

    public static List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";
            conexao = DriverManager.getConnection(URL, "root", "");
            instrucaoSQL = conexao.prepareStatement("select * from Cliente");
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {            
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");

                listaClientes.add(new Cliente( nome, cpf, email, telefone));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }
    
    public static boolean addCliente(Cliente cliente) { //pra criar um registro na tabela produto
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into Cliente(nome,cpf,email,telefone) values(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getCpf());
            instrucaoSQL.setString(3, cliente.getEmail());
            instrucaoSQL.setString(4, cliente.getTelefone());
           
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    cliente.setCodCliente(generatedKeys.getInt(1));

                } else {
                    throw new SQLException("Falha ao obter o código do Cliente.");
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
