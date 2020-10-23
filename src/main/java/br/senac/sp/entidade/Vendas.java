/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import java.sql.Time;

/**
 *
 * @author eduardo
 */
public class Vendas  {
    
    private int codVendas;
    private Time diahora ;
    private double total;

    public int getCodVendas() {
        return codVendas;
    }

    public void setCodVendas(int codVendas) {
        this.codVendas = codVendas;
    }

    public Time getDiahora() {
        return diahora;
    }

    public void setDiahora(Time diahora) {
        this.diahora = diahora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    //codCliente e codUnidade eu pego das outras? um extends?

    
    
    
    
}
