package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;

public class Banco extends EntidadeBaseAbstrata {
    private String nome;

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Dados do Banco \n" 
                + "Nome: " + nome + "\n";
    }
    
   
    
    
}
