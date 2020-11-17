package com.utm.cs.service.validation;

import com.utm.cs.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessValidationService {

    @Autowired
    private UserRepository repository;

    public boolean validateEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }
}
