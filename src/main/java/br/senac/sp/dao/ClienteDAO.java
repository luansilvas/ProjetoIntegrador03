/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Unidade;
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
        ResultSet rs;
        Connection conexao;
        PreparedStatement instrucaoSQL;

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
                int codUnidade = rs.getInt("Unidade_codUnidade");

                listaClientes.add(new Cliente(nome, cpf, email, telefone, codUnidade));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }

    public static boolean addCliente(Cliente cliente) {
        
        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into Cliente(nome,cpf,email,telefone,Unidade_codUnidade) values(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getCpf());
            instrucaoSQL.setString(3, cliente.getEmail());
            instrucaoSQL.setString(4, cliente.getTelefone());
            instrucaoSQL.setInt(5, cliente.getCodUnidade());

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
                
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
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

    public static boolean deleteCliente(String cpf) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = DriverManager.getConnection(URL, "root", "");

            instrucaoSQL = conexao.prepareStatement("delete from cliente where cpf=?");

            instrucaoSQL.setString(1, cpf);
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

    public static Cliente getClientes(String cpf) {
        Cliente clientes = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";
            conexao = DriverManager.getConnection(URL, "root", "");
            instrucaoSQL = conexao.prepareStatement("select * from Cliente where cpf=?");
            instrucaoSQL.setString(1, cpf);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                int codUnidade = rs.getInt("Unidade_codUnidade");
                clientes = new Cliente(nome, cpf, email, telefone, codUnidade);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public static Unidade getUnidade(String cpf) {

        Unidade unidade = new Unidade();
        Cliente clientes = null;
        ResultSet rs;
        Connection conexao;
        PreparedStatement instrucaoSQL;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";
            conexao = DriverManager.getConnection(URL, "root", "");
            instrucaoSQL = conexao.prepareStatement("select * from Cliente where cpf=?");
            instrucaoSQL.setString(1, cpf);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                unidade.setCodUnidade(rs.getInt("Unidade_codUnidade"));
                switch (unidade.getCodUnidade()) {
                    case 1:
                        unidade.setNome("Matriz");
                        break;
                    case 2:
                        unidade.setNome("Campina Grande");
                        break;
                    case 3:
                        unidade.setNome("Brasília");
                        break;
                    case 4:
                        unidade.setNome("Joinville");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidade;
    }

    public static boolean updateCliente(Cliente cliente, int codUnidade) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";

            conexao = DriverManager.getConnection(URL, "root", "");

            instrucaoSQL = conexao.prepareStatement("update Cliente set nome=?,email=?,telefone=?,Unidade_codUnidade=?  where cpf=?");

            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getEmail());
            instrucaoSQL.setString(3, cliente.getTelefone());
            instrucaoSQL.setInt(4, codUnidade);
            instrucaoSQL.setString(5, cliente.getCpf());
            instrucaoSQL.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                retorno = true;
                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;

    }

}