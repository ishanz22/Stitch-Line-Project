package com.maharaja.security.controllers;


import com.maharaja.security.repository.UserRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maharaja.security.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
   @Autowired
private UserRepo userRepo;

    @GetMapping("/")
    public List<Users> GetUsers() {
        return userRepo.findAll();
    }
    @GetMapping("/{id}")
    public Users GetUser(@PathVariable String id) {
        return userRepo.findById(id).orElse(null);
    }
    @PostMapping("/")
    public Users postMethodName(@RequestBody Users users) {
        return userRepo.save(users);
    }
    @PutMapping("/")
    public Users PutMapping(@RequestBody Users newUsers) {
        Users oldUsers = userRepo.findById(newUsers.getId()).orElse(null);
        oldUsers.setName(newUsers.getName());
        oldUsers.setEmail(newUsers.getEmail());
        oldUsers.setPassword(newUsers.getPassword());
        userRepo.save(oldUsers);
        return oldUsers;
    }
    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable String id) {
        userRepo.deleteById(id);
        return id;
    }
}
