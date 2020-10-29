package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.ProdutoVendaDAO;
import br.senac.sp.entidade.ProdutoUnidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class CancelarProdutoVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProdutoUnidade> listaProdutoVenda = ProdutoVendaDAO.getProdutos();
        for (ProdutoUnidade pru : listaProdutoVenda) {
            ProdutoDAO.aumentaEstoque(pru.getCodProduto());
        }
        if (ProdutoVendaDAO.cancelarProdutoVenda()) {
            response.sendRedirect("Loja");

        } else {
            response.sendRedirect("Loja");

        }
    }

}
