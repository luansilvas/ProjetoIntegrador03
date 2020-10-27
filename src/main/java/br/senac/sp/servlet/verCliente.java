/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Unidade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class verCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getClientes(cpf);
        Unidade unidade = ClienteDAO.getUnidade(cpf);

        request.setAttribute("cliente", cliente);
        request.setAttribute("unidade", unidade);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/verCliente.jsp");
        requestDispatcher.forward(request, response);
    }
}
