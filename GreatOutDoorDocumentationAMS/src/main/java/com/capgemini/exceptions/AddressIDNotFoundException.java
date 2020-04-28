package com.capgemini.exceptions;

@SuppressWarnings("serial")
public class AddressIDNotFoundException extends RuntimeException{
    public AddressIDNotFoundException(String msg){
        super(msg);
    }

    public AddressIDNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}

