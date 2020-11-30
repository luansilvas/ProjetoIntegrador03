/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Usuario;
import br.senac.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luans
 */
public class UsuarioDAO {

    public static Usuario getUsuario(String login) {
        Usuario user = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from usuario inner join Funcionario on Funcionario_codFuncionario = codFuncionario where login=?");
            instrucaoSQL.setString(1, login);
            rs = instrucaoSQL.executeQuery();

            if (rs.next()) {

                int codUsuario = rs.getInt("codUsuario");
                String cargo = rs.getString("cargo");
                String log = rs.getString("login");
                String pass = rs.getString("senha");
                
                int codFunc = rs.getInt("Funcionario_codFuncionario");
                int idFuncionario = rs.getInt("codFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String celular = rs.getString("celular");
                int codUnidade = rs.getInt("Unidade_codUnidade");

                user = new Usuario(codUsuario,log,cargo,pass,codFunc,idFuncionario,nome,cpf,email,celular,codUnidade);
                
                
                

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    public static boolean addFuncionario(Usuario func) {

        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into Usuario(login,senha,cargo,Funcionario_codFuncionario) values(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, func.getLogin());
            instrucaoSQL.setString(2, func.codificarSenha(func.getSenha()));
            instrucaoSQL.setString(3, func.getCargo());
            instrucaoSQL.setInt(4, func.getCodFuncionario());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    func.setFuncionario_codFuncionario(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
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
    public static boolean updateFuncionario(Usuario func) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update Usuario set login=?,senha=?,cargo=? where Funcionario_codFuncionario=?");

            instrucaoSQL.setString(1, func.getLogin());
            instrucaoSQL.setString(2, func.codificarSenha(func.getSenha()));
            instrucaoSQL.setString(3, func.getCargo());
            instrucaoSQL.setInt(4, func.getFuncionario_codFuncionario());
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
