package com.spring.tutorial.ecommercebackend.service;

import com.spring.tutorial.ecommercebackend.api.model.RegistrationBody;
import com.spring.tutorial.ecommercebackend.exception.UserAlreadyExistsException;
import com.spring.tutorial.ecommercebackend.model.LocalUser;
import com.spring.tutorial.ecommercebackend.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;
    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
//      TODO: encrypt password
        user.setPassword(registrationBody.getPassword());

        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());

        user = localUserDAO.save(user);

        return user;
//      TODO: error handling
    }
}
