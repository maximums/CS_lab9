package com.utm.cs.errors;

public class EmailAlreadyRegistered extends Throwable{
    public EmailAlreadyRegistered(){
        super("Email Already Registered");
    }
}
