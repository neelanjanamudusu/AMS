package com.capgemini.exceptions;

@SuppressWarnings("serial")
public class RetailorIDNotFoundException extends RuntimeException{
    public RetailorIDNotFoundException(String msg){
        super(msg);
    }

    public RetailorIDNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
