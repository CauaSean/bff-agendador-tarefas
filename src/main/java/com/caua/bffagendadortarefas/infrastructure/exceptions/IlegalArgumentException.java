package com.caua.bffagendadortarefas.infrastructure.exceptions;

public class IlegalArgumentException extends RuntimeException{

    public IlegalArgumentException(String mensagem){
        super(mensagem);
    }

    public IlegalArgumentException (String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
