/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luans
 */
@Getter
@Setter
public class Usuario extends Funcionario{

    private int codUsuario;
    private String login;
    private String cargo;
    private String senha;
    private int Funcionario_codFuncionario;

    public boolean isAdmin() {
        return this.cargo.equalsIgnoreCase("gerente");

    }
    
    
    
    
    
    public String codificarSenha(String senha){
    return BCrypt.withDefaults().hashToString(12, senha.toCharArray());

    }
    public boolean validarSenha(String senha){
    BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(),this.getSenha());
    return response.verified;
    }

    public Usuario(int codUsuario, String login, String cargo, String senha, int Funcionario_codFuncionario, int codFuncionario, String nome, String cpf, String email, String celular, int codUnidade) {
        super(codFuncionario, nome, cpf, email, celular, codUnidade);
        this.codUsuario = codUsuario;
        this.login = login;
        this.cargo = cargo;
        this.senha = senha;
        this.Funcionario_codFuncionario = Funcionario_codFuncionario;
    }


    
    
    
    

}
