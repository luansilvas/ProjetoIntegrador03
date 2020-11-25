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
public class Usuario {

    private int codUsuario;
    private String login;
    private String cargo;
    private String senha;
    private int Funcionario_codFuncionario;

    public boolean isAdmin() {
        return this.cargo.equalsIgnoreCase("gerente");

    }

    public Usuario(int codUsuario, String cargo, String login, String senha, int Funcionario_codFuncionario) {
        this.codUsuario = codUsuario;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.Funcionario_codFuncionario = Funcionario_codFuncionario;

    }
    
    
    

}
