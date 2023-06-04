package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;

public class Conta extends EntidadeBaseAbstrata{
    private String numero;
    private String digito;
    private double saldo;
    private int tipo;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String numero, String digito, double saldo, int tipo, 
            Agencia agencia, Pessoa pessoa) {
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipo = tipo;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
        return "Dados da Conta: \n" 
                + "Número: " + numero + "\n"
                + "Digito: " + digito + "\n"
                + "Saldo: " + saldo + "\n"
                + "Tipo: " + tipo + "\n"
                + pessoa + "\n"
                + agencia + "\n";
    }
    
    
    
}
