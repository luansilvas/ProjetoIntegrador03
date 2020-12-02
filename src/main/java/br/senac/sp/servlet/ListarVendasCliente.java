/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.vendaDAO;
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
public class ListarVendasCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            if (usuario.getCargo().equals("Gerente")) {
                List<Venda> listaVendas = new ArrayList();

                if (usuario.getCodUnidade() == 1) {
                    listaVendas = vendaDAO.getVenda();
                } else {
                    listaVendas = vendaDAO.getVenda(usuario.getCodUnidade());

                }

                request.setAttribute("listaVendas", listaVendas);
                RequestDispatcher requestDispatcher = getServletContext()
                        .getRequestDispatcher("/protegido/extrairRelatorioCliente.jsp");
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

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        String cpf = "", categoria = " ", dia = " ";

        cpf = request.getParameter("cpf");

        int codUnidade = usuario.getCodUnidade();

        List<Venda> listaVendas = vendaDAO.getVendasCliente(codUnidade, cpf);
        request.setAttribute("listaVendas", listaVendas);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/extrairRelatorioCliente.jsp");
        requestDispatcher.forward(request, response);
    }
}
