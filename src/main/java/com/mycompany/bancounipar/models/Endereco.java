package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;

public class Endereco extends EntidadeBaseAbstrata {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private Pessoa pessoa;
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String bairro, String cep, String complemento, Pessoa pessoa, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.pessoa = pessoa;
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Dados do Endereço: \n" 
                + "Logradouro: " + logradouro + "\n"
                + "Número: " + numero + "\n"
                + "Bairro: " + bairro + "\n"
                + "CEP:" + cep + "\n" 
                + "Complemento: " + complemento + "\n"
                + pessoa + "\n" 
                + cidade + "\n";
    }

    
    
    
}
