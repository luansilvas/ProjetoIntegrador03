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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class verProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        ProdutoUnidade produto = ProdutoDAO.getProduto(codProduto);
        request.setAttribute("produto", produto);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/verProduto.jsp");
        requestDispatcher.forward(request, response);

    }

    //@Override
    /* protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long cpf = Long.parseLong(request.getParameter("cpf"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);

        try {
            ClienteDAO.updateCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }

    }*/
}
