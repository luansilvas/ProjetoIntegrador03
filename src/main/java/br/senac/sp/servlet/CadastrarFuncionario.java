/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.FuncionarioDAO;
import br.senac.sp.entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class CadastrarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String celular = request.getParameter("telefone");

        int codUnidade = Integer.parseInt(request.getParameter("unidade"));

        String login = request.getParameter("login");
        String cargo = request.getParameter("cargo");

        String pass = request.getParameter("senha");

        Usuario func = new Usuario(0, login, cargo, pass, 0, 0, nome, cpf, email, celular, codUnidade);

        FuncionarioDAO.addFuncionario(func);

        response.sendRedirect("protegido/sucessoCliente.jsp");

    }

}
