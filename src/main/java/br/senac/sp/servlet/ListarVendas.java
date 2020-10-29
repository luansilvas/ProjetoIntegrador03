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
public class ListarVendas extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Venda> listaVendas = vendaDAO.getVendas();
        request.setAttribute("listaVendas", listaVendas);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/extrairRelatorio.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String cpf = "", categoria = " ", dia = " ";

            cpf = request.getParameter("cpf");

            categoria = request.getParameter("categoria");

            int codUnidade = Integer.parseInt(request.getParameter("codUnidade"));

            List<Venda> listaVendas = vendaDAO.getVendas(codUnidade, cpf, categoria);
            request.setAttribute("listaVendas", listaVendas);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/extrairRelatorio.jsp");
            requestDispatcher.forward(request, response);
        }

    
    
    }


