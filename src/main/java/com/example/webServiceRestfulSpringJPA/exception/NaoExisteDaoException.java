package com.example.webServiceRestfulSpringJPA.exception;

public class NaoExisteDaoException extends RuntimeException{
    
    String message;

    public NaoExisteDaoException(String message){
        this.message = message;
    }
    
}
