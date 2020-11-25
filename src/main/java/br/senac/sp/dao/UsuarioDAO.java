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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luans
 */
public class UsuarioDAO {

    public static Usuario getUsuario(String login, String senha) {
        Usuario user = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from usuario where login=? and senha=?;");
            System.out.println(login +" e "+senha);
            instrucaoSQL.setString(1, login);
            instrucaoSQL.setString(2, senha);
            rs = instrucaoSQL.executeQuery();

            if (rs.next()) {

                int codUsuario = rs.getInt("codUsuario");
                String cargo = rs.getString("cargo");
                String log = rs.getString("login");
                String pass = rs.getString("senha");
                int codFunc = rs.getInt("Funcionario_codFuncionario");
                System.out.println(cargo+"   "+senha);

                user = new Usuario(codUsuario, cargo, log, pass, codFunc);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

}
