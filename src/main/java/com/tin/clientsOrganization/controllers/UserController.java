package com.tin.clientsOrganization.controllers;

import com.tin.clientsOrganization.dtos.UserDTO;
import com.tin.clientsOrganization.entities.ApplicationUser;
import com.tin.clientsOrganization.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ApplicationUser signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
        return user;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        ApplicationUser applicationUser = this.toApplicationUser(userDTO);
        applicationUserRepository.save(applicationUser);
        return userDTO;
    }

    private ApplicationUser toApplicationUser (UserDTO userDTO){
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        applicationUser.setUsername(userDTO.getUsername());
        return applicationUser;
    }
}
