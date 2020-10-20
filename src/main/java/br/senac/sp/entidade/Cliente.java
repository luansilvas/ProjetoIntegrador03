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
    
    private String nome;
    private String cpf;
    private String email;
    
    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        
    } 

    @Override
    public String toString() {
        return String.format("Nome %s | CPF %s | E-mail %s", 
                this.getNome(), this.getCpf(), this.getEmail());
    }   
    
}
