/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.vendaDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.Usuario;
import br.senac.sp.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
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
public class ListarVendas extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            List<Venda> listaVendas = new ArrayList();
            if (usuario.getCargo().equals("Gerente")) {
                if (usuario.getCodUnidade() == 1) {
                    listaVendas = vendaDAO.getVendas();
                } else {
                    listaVendas = vendaDAO.getVendasUnidade(usuario.getCodUnidade());
                }

                request.setAttribute("listaVendas", listaVendas);

                RequestDispatcher requestDispatcher = getServletContext()
                        .getRequestDispatcher("/protegido/extrairRelatorio.jsp");
                requestDispatcher.forward(request, response);
            } else if (!usuario.getCargo().equals("Gerente")) {
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

        String cpf = "", categoria = " ", dia = " ";

        cpf = request.getParameter("cpf");

        categoria = request.getParameter("categoria");

        int codUnidade = Integer.parseInt(request.getParameter("codUnidade"));

        dia = request.getParameter("dia");

        List<Venda> listaVendas = vendaDAO.getVendas(codUnidade, cpf, categoria,dia);
        request.setAttribute("listaVendas", listaVendas);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/extrairRelatorio.jsp");
        requestDispatcher.forward(request, response);
    }

}
