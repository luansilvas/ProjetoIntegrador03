/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author luans
 */
public class ProdutoVenda extends ProdutoUnidade{

    private int codProdutoVenda;
    private int Venda_codVenda;


    public int getCodProdutoVenda() {
        return codProdutoVenda;
    }

    public void setCodProdutoVenda(int codProdutoVenda) {
        this.codProdutoVenda = codProdutoVenda;
    }

    public int getVenda_codVenda() {
        return Venda_codVenda;
    }

    public void setVenda_codVenda(int Venda_codVenda) {
        this.Venda_codVenda = Venda_codVenda;
    }


}
