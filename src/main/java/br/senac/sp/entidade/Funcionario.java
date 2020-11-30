/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luans
 */
@Getter
@Setter
public class Funcionario {

    private int codFuncionario;
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private int codUnidade;

    public Funcionario(int codFuncionario, String nome, String cpf, String email, String celular, int codUnidade) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.codUnidade = codUnidade;
    }
}
