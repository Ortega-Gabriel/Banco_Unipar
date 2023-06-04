package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;


public class Telefone extends EntidadeBaseAbstrata{
    private String numero;
    private int operadora;
    private Agencia agencia;
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(String numero, int operadora, Agencia agencia, Pessoa pessoa) {
        this.numero = numero;
        this.operadora = operadora;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getOperadora() {
        return operadora;
    }

    public void setOperadora(int operadora) {
        this.operadora = operadora;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Dados do Telefone: " 
                + "Número: " + numero + "\n"
                + "Operadora: " + operadora + "\n"
                + agencia + "\n" 
                + pessoa + "\n";
    }

    
    
    
}
