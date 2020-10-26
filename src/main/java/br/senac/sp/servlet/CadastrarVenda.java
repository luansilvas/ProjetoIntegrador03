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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eduardo
 */
public class CadastrarVenda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Vendas vend = new Vendas();
        //vend.setDiahora(Integer.parseTime(request.getParameter("diahora")));
        vend.setTotal(Integer.parseInt(request.getParameter("total")));

        
        if (VendasDAO.addVenda(vend)) {
            response.sendRedirect("sucessoProduto.jsp?codProd");

        }else{
                   

        
        }
        
        
        
     
    }
}
