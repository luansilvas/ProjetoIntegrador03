/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.ProdutoUnidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class ExcluirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ProdutoUnidade prod = new ProdutoUnidade();
        prod.setTitulo(request.getParameter("titulo"));
        prod.setCodProduto(Integer.parseInt(request.getParameter("codProduto")));
        
        
        
        if (ProdutoDAO.deleteProduto(prod)) {
            response.sendRedirect("ListarProdutos");

        } else {
            response.sendRedirect("ListarProdutos");
        }
    }

}
