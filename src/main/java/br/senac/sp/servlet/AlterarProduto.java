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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class AlterarProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        ProdutoUnidade produto = ProdutoDAO.getProduto(codProduto);
        request.setAttribute("produto", produto);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/alterarProduto.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            ProdutoUnidade prod = new ProdutoUnidade();
            prod.setTitulo(request.getParameter("titulo"));
            prod.setCategoria(request.getParameter("categoria"));
            prod.setDescricao(request.getParameter("descricao"));
            prod.setValor(Double.parseDouble(request.getParameter("valor")));
            prod.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

            prod.setCodUnidade(Integer.parseInt(request.getParameter("unidade")));

            prod.setCodProduto(Integer.parseInt(request.getParameter("codProduto")));
            prod.setStatus(1);
            if (ProdutoDAO.updateProduto(prod)) {
                response.sendRedirect("sucessoProduto.jsp?");

            } else {

                response.sendRedirect("sucessoProduto.jsp?");

            }
        } 
    
}
