package com.mycompany.bancounipar.models;

import java.util.Date;


public class PessoaFisica extends Pessoa{
    private Pessoa pessoa;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(Pessoa pessoa, String nome, String cpf, String rg, 
            Date dataNascimento, String email) {
        super(email);
        this.pessoa = pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Dados da Pessoa Fisica \n" 
                + "Pessoa: " + pessoa + "\n"
                + "Nome: " + nome + "\n"
                + "CPF:" + cpf + "\n"
                + "RG: " + rg + "\n"
                + "Data de Nascimento: " + dataNascimento + "\n";
    }
    
    
}
