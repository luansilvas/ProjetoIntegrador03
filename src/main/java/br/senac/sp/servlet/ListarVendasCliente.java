/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.vendaDAO;
import br.senac.sp.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        List<Venda> listaVendas = vendaDAO.getVenda();
        request.setAttribute("listaVendas", listaVendas);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/extrairRelatorioCliente.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String cpf = "", categoria = " ", dia = " ";

            cpf = request.getParameter("cpf");


            int codUnidade = Integer.parseInt(request.getParameter("codUnidade"));

            List<Venda> listaVendas = vendaDAO.getVendasCliente(codUnidade, cpf);
            request.setAttribute("listaVendas", listaVendas);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/extrairRelatorioCliente.jsp");
            requestDispatcher.forward(request, response);
        }
}
