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
public class ProdutoUnidade extends Produto{
private int codProdUnidade;
private double valor;
private int status;
private int quantidade;


    public ProdutoUnidade(int codProduto, String titulo, String categoria, String foto, String descricao, double valor, int quantidade, int status){
    this.valor = valor;
    this.status = status;
    this.quantidade = quantidade;
    this.setCodProduto(codProduto);
    this.setTitulo(titulo);
    this.setCategoria(categoria);
    this.setDescricao(descricao);
    this.setFoto(foto);

}

    public ProdutoUnidade(int codProdutoUnidade,double valor,int status, int quantidade,int codProduto, String titulo, String categoria,String descricao,String foto, int codUnidade,String nome){
    this.codProdUnidade = codProdutoUnidade;
    this.valor = valor;
    this.status = status;
    this.quantidade = quantidade;
    this.setCodProduto(codProduto);
    this.setTitulo(titulo);
    this.setCategoria(categoria);
    this.setDescricao(descricao);
    this.setFoto(foto);
    this.setCodUnidade(codUnidade);
    this.setNome(nome);
}



    public int getCodProdUnidade() {
        return codProdUnidade;
    }

    public void setCodProdUnidade(int codProdUnidade) {
        this.codProdUnidade = codProdUnidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
