package com.example.demo.service.servers.tools.exceptions;

public class NullErrorException extends RuntimeException{
    public NullErrorException(){}
    public NullErrorException(String msg){
        super(msg);
    }
    public NullErrorException(String msg,Throwable cause){
        super(msg,cause);
    }
    public NullErrorException(Throwable cause){
        super(cause);
    }
}
