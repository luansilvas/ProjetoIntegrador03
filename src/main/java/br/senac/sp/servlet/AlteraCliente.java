/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class AlteraCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getClientes(cpf);

        request.setAttribute("cliente", cliente);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        int codUnidade = Integer.parseInt(request.getParameter("unidade"));
        
        Cliente cliente = ClienteDAO.getClientes(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        
        if(ClienteDAO.updateCliente(cliente, codUnidade)){
            response.sendRedirect("sucessoCliente.jsp");
        }
        

    }
}
