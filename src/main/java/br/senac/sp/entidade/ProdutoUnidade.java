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
