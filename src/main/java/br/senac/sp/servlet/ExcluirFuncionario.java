/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.FuncionarioDAO;
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
public class ExcluirFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String temp = request.getParameter("codFuncionario");
        int codFuncionario = Integer.parseInt(temp);
        if (FuncionarioDAO.deleteFuncionario(codFuncionario)) {
            response.sendRedirect("ListarFuncionario");
        } else {
            response.sendRedirect("ListarFuncionario");
        }
    }
}
