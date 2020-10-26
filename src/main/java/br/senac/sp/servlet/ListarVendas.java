/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.VendasDAO;
import br.senac.sp.entidade.Vendas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eduardo
 */
public class ListarVendas extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Vendas> vendas = VendasDAO.getVendas();
        request.setAttribute("listaVendas", vendas);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/listaVendas.jsp");
        requestDispatcher.forward(request, response);
    }

}
