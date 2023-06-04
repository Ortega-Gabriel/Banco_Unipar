package com.mycompany.bancounipar.exceptions;

public class CampoNaoInformadoException extends Exception{
    
    public CampoNaoInformadoException(String campo){
        super("O Campo " + campo + "Não foi Informado. Verifique!"); 
    }
}
