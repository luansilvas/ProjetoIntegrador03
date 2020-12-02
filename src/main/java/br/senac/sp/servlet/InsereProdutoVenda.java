/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.ProdutoVendaDAO;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class InsereProdutoVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession sessao = httpRequest.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            
            
            if (usuario.getCargo().equals("Vendedor")) {            

            int codProduto = Integer.parseInt(request.getParameter("codProduto"));
            double valor = Double.parseDouble(request.getParameter("valor"));
            ProdutoUnidade p1 = new ProdutoUnidade();
            p1.setCodProduto(codProduto);
            p1.setValor(valor);
            p1.setCodFuncionario(usuario.getCodFuncionario());
            
            ProdutoVendaDAO.addProduto(p1);
            response.sendRedirect("Loja");
            }else if (!usuario.getCargo().equals("Vendedor")) {
                response.sendRedirect(request.getContextPath() + "/protegido/semAutorizacao.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
