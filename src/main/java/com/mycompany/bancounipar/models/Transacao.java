package com.mycompany.bancounipar.models;

import com.mycompany.bancounipar.abstracts.EntidadeBaseAbstrata;
import java.util.Date;

public class Transacao extends EntidadeBaseAbstrata{
    private Date datahora;
    private double valor;
    private int tipo;
    private Conta ContaOrigem;
    private Conta ContaDestino;

    public Transacao() {
    }

    public Transacao(Date datahora, double valor, int tipo, Conta ContaOrigem, Conta ContaDestino) {
        this.datahora = datahora;
        this.valor = valor;
        this.tipo = tipo;
        this.ContaOrigem = ContaOrigem;
        this.ContaDestino = ContaDestino;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Conta getContaOrigem() {
        return ContaOrigem;
    }

    public void setContaOrigem(Conta ContaOrigem) {
        this.ContaOrigem = ContaOrigem;
    }

    public Conta getContaDestino() {
        return ContaDestino;
    }

    public void setContaDestino(Conta ContaDestino) {
        this.ContaDestino = ContaDestino;
    }

    

    @Override
    public String toString() {
        return "Dados da Transação: " 
                + "Data e Hora da Transação: " + datahora + "\n"
                + "Valor: " + valor + "\n"
                + "Tipo: " + tipo + "\n"
                + "Conta de Origem: " + ContaOrigem + "\n"
                + "Conta de Destino: " + ContaDestino + "\n";
    }
    
    
}
