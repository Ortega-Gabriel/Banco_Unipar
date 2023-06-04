package com.mycompany.bancounipar.exceptions;

public class TamanhoCampoInvalidoException extends Exception{
    
    public TamanhoCampoInvalidoException(String campo, int tamanho){
        super("O Campo " + campo + "foi informado com o Tamanho " + tamanho
                + " caracteres invalido. Verifique!");
    }
}
