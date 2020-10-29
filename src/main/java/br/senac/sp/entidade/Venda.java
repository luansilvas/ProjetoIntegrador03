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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda{

    private int codVenda;
    private double total;
    private int Funcionario_codFuncionario;
    private int Cliente_codCliente;
    private String datahora;
    private int status;
    private String CPF;
    private String produto_categoria;
    
    public Venda(){}
    
    public Venda(int codVenda) {
        this.codVenda = codVenda;

    }

    public Venda(int codVenda, double total, int funcionario, int codCliente, int codFuncionario, String datahora, int status) {
        this.codVenda = codVenda;
        this.total = total;
        this.Cliente_codCliente = codCliente;
        this.Funcionario_codFuncionario = codFuncionario;
        this.datahora = datahora;
    }

}
