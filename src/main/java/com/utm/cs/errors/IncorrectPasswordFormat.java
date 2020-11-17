package com.utm.cs.errors;

public class IncorrectPasswordFormat extends Throwable{
    public IncorrectPasswordFormat() {
        super("Invalid Password Format");
    }
}
