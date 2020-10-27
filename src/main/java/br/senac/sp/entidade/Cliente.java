/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author Gustavo
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
    private int codCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int codUnidade;
    
    public Cliente(String nome, String cpf, String email, String telefone, int codUnidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.codUnidade = codUnidade;
    } 

    @Override
    public String toString() {
        return String.format("Nome %s | CPF %s | E-mail %s | Telefone %s", 
                this.getNome(), this.getCpf(), this.getEmail(), getTelefone());
    }   
    
}
