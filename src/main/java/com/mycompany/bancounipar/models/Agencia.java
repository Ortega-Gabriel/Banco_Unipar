
package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;


public class Agencia extends EntidadeBaseAbstrata{
    private String codigo;
    private String digito;
    private String razaoSocial;
    private String cnpj;
    private Banco banco;
    private String ra;

    public Agencia() {
    }

    public Agencia(String codigo, String digito, String razaoSocial, String cnpj, Banco banco, String ra) {
        this.codigo = codigo;
        this.digito = digito;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.banco = banco;
        this.ra = ra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Banco getBanco() {
        return banco;
    }
    
    public String getRa() {
        return ra;
    }
    
    public void setRa() {
        this.ra = ra;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Dados da Agência \n" 
                + "Código da Agência: " + codigo + "\n "
                + "Digito: " + digito + "\n"
                + "Razão Social: " + razaoSocial + "\n"
                + "CNPJ: " + cnpj + "\n" 
                + banco + "\n";
    }

   
    
}
