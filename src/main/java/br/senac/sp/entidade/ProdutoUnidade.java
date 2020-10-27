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
public class ProdutoUnidade extends Produto {

    private int codProdUnidade;
    private double valor;
    private int status;
    private int quantidade;
    private String nomeUnidade;
    private int codProdutoVenda;
    private int codFuncionario;
    private int statusProdutoVenda;
    

    public int getCodProdutoVenda() {
        return codProdutoVenda;
    }

    public void setCodProdutoVenda(int codProdutoVenda) {
        this.codProdutoVenda = codProdutoVenda;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getStatusProdutoVenda() {
        return statusProdutoVenda;
    }

    public void setStatusProdutoVenda(int statusProdutoVenda) {
        this.statusProdutoVenda = statusProdutoVenda;
    }


    public int getCodProdUnidade() {
        return codProdUnidade;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String NomeUnidade) {
        this.nomeUnidade = NomeUnidade;
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
