package com.spring.tutorial.ecommercebackend.api.model;

import jakarta.validation.constraints.Email;

public class RegistrationBody {

    private String username;
//  part of Validation dep.
    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
