package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;

public class Pessoa extends EntidadeBaseAbstrata{
    private String email;

    public Pessoa() {
    }

    public Pessoa(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dados da Pessoa: \n" 
                + "Email: " + email + "\n";
    }

    
    
    
}
