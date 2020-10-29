/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoVendaDAO;
import br.senac.sp.entidade.ProdutoUnidade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class ComprarProduto extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        double valor =Double.parseDouble(request.getParameter("valor"));
        ProdutoUnidade p1 = new ProdutoUnidade();
        p1.setCodProduto(codProduto);
        p1.setValor(valor);
        ProdutoVendaDAO.addProduto(p1);
        response.sendRedirect("FecharPedido");
    }
}
