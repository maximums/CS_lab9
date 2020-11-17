package com.utm.cs.errors;

public class IncorrectEmailFormat extends Throwable{
    public IncorrectEmailFormat() {
        super("Invalid Email Format");
    }
}
