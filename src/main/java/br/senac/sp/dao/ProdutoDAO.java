
package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.ProdutoUnidade;
import br.senac.sp.servlet.ServletBD;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author luans
 */
public class ProdutoDAO {
    public static List<ProdutoUnidade> getProdutos() {
        List<ProdutoUnidade> listaProdutos= new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from PRODUTO p where p.status=1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codProd = rs.getInt("p.codProduto");
                String titulo = rs.getString("p.titulo");
                String categoria = rs.getString("p.categoria");
                String foto = rs.getString("p.foto");
                String descricao = rs.getString("p.descricao");
                double valor = rs.getDouble("p.valor");
                int quantidade = rs.getInt("p.quantidade");
                int status = rs.getInt("p.status");
                
                //int codProdUnidade = rs.getInt("p.codProduto");

                listaProdutos.add(new ProdutoUnidade(codProd,titulo, categoria, foto,descricao,valor,quantidade,status));
           
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }
    
    
    
    
    
    
    
    
}
