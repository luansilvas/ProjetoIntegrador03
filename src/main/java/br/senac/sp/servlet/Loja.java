/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.ProdutoVendaDAO;
import br.senac.sp.dao.vendaDAO;
import br.senac.sp.entidade.ProdutoUnidade;
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
public class Loja extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");


            if (usuario.getCargo().equals("Vendedor")) {

                List<ProdutoUnidade> listaProdutos = ProdutoDAO.getProdutos(usuario.getCodUnidade());
                request.setAttribute("listaProdutos", listaProdutos);
                
                List<ProdutoUnidade> listaProdutoVenda = ProdutoVendaDAO.getProdutosFuncionario(usuario.getCodFuncionario());
                request.setAttribute("listaProdutoVenda", listaProdutoVenda);
                
                
                
                RequestDispatcher requestDispatcher = getServletContext()
                        .getRequestDispatcher("/protegido/loja.jsp");
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

        int codUnidade = Integer.parseInt(request.getParameter("codUnidade"));

        List<ProdutoUnidade> listaProdutos = ProdutoDAO.getProdutos(codUnidade);
        request.setAttribute("listaProdutos", listaProdutos);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/loja.jsp");
        requestDispatcher.forward(request, response);
    }
}
