/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.Usuario;
import java.io.IOException;
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
public class AlterarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");

            if (usuario.getCargo().equals("Analista BackOffice")) {

                int codProduto = Integer.parseInt(request.getParameter("codProduto"));
                ProdutoUnidade produto = ProdutoDAO.getProduto(codProduto);
                request.setAttribute("produto", produto);

                RequestDispatcher requestDispatcher = getServletContext()
                        .getRequestDispatcher("/protegido/alterarProduto.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {

            response.sendRedirect(request.getContextPath() + "/login.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");

            ProdutoUnidade prod = new ProdutoUnidade();
            prod.setTitulo(request.getParameter("titulo"));
            prod.setCategoria(request.getParameter("categoria"));
            prod.setDescricao(request.getParameter("descricao"));
            prod.setValor(Double.parseDouble(request.getParameter("valor")));
            prod.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

            prod.setCodUnidade(usuario.getCodUnidade());

            prod.setCodProduto(Integer.parseInt(request.getParameter("codProduto")));
            prod.setStatus(1);
            ProdutoDAO.updateProduto(prod);
            response.sendRedirect("protegido/sucessoProduto.jsp?");
        } catch (Exception e) {

            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
