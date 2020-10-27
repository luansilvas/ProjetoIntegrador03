/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.ProdutoVendaDAO;
import br.senac.sp.dao.vendaDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.ProdutoUnidade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class RegistrarVenda extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CPF = request.getParameter("cpf");
        int codUnidade = Integer.parseInt(request.getParameter("codUnidade"));
        int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));

        Cliente cli = ClienteDAO.getClientes(CPF);


        double total = 0.0;
        List<ProdutoUnidade> listaProdutoVenda = ProdutoVendaDAO.getProdutos();
        for (ProdutoUnidade item : listaProdutoVenda) {
            total += item.getValor();
        }
        int codVenda = vendaDAO.newSale(total, codFuncionario, cli.getCodCliente(), codUnidade);
        if (codVenda > 0 && ProdutoVendaDAO.FecharProdutoVenda(codVenda, codFuncionario)) {
            response.sendRedirect("sucessoProduto.jsp?codProd");
        }

        //   }
    }
}
