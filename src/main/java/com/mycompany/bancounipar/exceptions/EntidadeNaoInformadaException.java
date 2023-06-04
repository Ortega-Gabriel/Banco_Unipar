package com.mycompany.bancounipar.exceptions;


public class EntidadeNaoInformadaException extends Exception{
    
    public EntidadeNaoInformadaException(String entidade){
        
        super(entidade + " Não foi Informada. Verifique!");
    }
}
