/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Unidade;
import br.senac.sp.entidade.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
public class AlteraCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");

            if (usuario.getCargo().equals("Vendedor")) {

                String cpf = request.getParameter("cpf");
                Cliente cliente = ClienteDAO.getClientes(cpf);
                Unidade unidade = ClienteDAO.getUnidade(cpf);

                request.setAttribute("cliente", cliente);
                request.setAttribute("unidade", unidade);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/alterarCliente.jsp");
                requestDispatcher.forward(request, response);
            } else if (!usuario.getCargo().equals("Vendedor")) {
                response.sendRedirect(request.getContextPath() + "/protegido/semAutorizacao.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        int codUnidade = usuario.getCodUnidade();

        Cliente cliente = ClienteDAO.getClientes(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);

        ClienteDAO.updateCliente(cliente, codUnidade);
        response.sendRedirect("protegido/sucessoCliente.jsp");

    }
}
