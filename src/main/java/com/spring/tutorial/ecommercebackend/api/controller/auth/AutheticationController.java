package com.spring.tutorial.ecommercebackend.api.controller.auth;

import com.spring.tutorial.ecommercebackend.api.model.RegistrationBody;
import com.spring.tutorial.ecommercebackend.exception.UserAlreadyExistsException;
import com.spring.tutorial.ecommercebackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutheticationController {

    private UserService userService;

    public AutheticationController(UserService userService) {
        this.userService = userService;
    }

    //    @Valid validates reg body - has to be controller level and not service level
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
