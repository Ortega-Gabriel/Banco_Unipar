package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;

public class Cidade extends EntidadeBaseAbstrata {
    
    private String nome;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dados da Cidade \n" 
                + "Nome: " + nome + "\n"
                + estado + "\n";
    }
    
    
   
    
}
