package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;


public class Pais extends EntidadeBaseAbstrata{
    private String nome;
    private String sigla;

    public Pais() {
    }

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Dados do Pais: \n" 
                + "Nome: " + nome + "\n"
                + "Sigla: " + sigla + "\n"
                + "Id: " + super.getId() + "\n"
                + "Ra: " + super.getRa() + "\n"
                + "Data do Cadastro" + super.getDataCadastro() + "\n";
    }

    
    
    
    
    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
