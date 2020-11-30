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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class AlterarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String temp = request.getParameter("codFuncionario");
        int codFuncionario = Integer.parseInt(temp);
        
        Usuario func = FuncionarioDAO.getFuncionario(codFuncionario);

        request.setAttribute("func", func);
       // request.setAttribute("unidade", unidade);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/alterarFuncionario.jsp");
        requestDispatcher.forward(request, response);

    }

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

        int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));

        Usuario func = new Usuario(0, login, cargo, pass, codFuncionario, codFuncionario, nome, cpf, email, celular, codUnidade);

        FuncionarioDAO.updateFuncionario(func);

        response.sendRedirect("ListarFuncionario");

    }

}
