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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luans
 */
public class ListarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");

            if (usuario.getCargo().equals("Analista TI")) {

                List<Usuario> funcionarios = FuncionarioDAO.getFuncionarios(usuario.getCodFuncionario());
                request.setAttribute("funcionarios", funcionarios);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/listaFuncionarios.jsp");
                requestDispatcher.forward(request, response);
            } else if (!usuario.getCargo().equals("Analista TI")) {
                response.sendRedirect(request.getContextPath() + "/protegido/semAutorizacao.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        }
    }

}
