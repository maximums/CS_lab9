package com.utm.cs.service.validation;

import org.springframework.stereotype.Service;

@Service
public class StructuralValidationService {
    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    public boolean validatePassword(String pass) {
        return pass.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }
}