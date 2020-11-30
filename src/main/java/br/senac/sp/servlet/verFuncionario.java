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
public class verFuncionario extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String temp = request.getParameter("codFuncionario");
        int codFuncionario = Integer.parseInt(temp);
        
        Usuario func = FuncionarioDAO.getFuncionario(codFuncionario);

        request.setAttribute("func", func);
       // request.setAttribute("unidade", unidade);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/verFuncionario.jsp");
        requestDispatcher.forward(request, response);

    }

}
