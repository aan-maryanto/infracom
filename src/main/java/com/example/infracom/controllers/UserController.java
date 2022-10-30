package com.example.infracom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.infracom.entity.Users;
import com.example.infracom.services.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/list")
    public ResponseEntity<?> users() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> user(@PathVariable String id) {
        Users users = usersService.getUserById(id).orElseThrow(() -> new RuntimeException("Data with Id : "+id+" Not Found"));
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Users users) {
        Users user = usersService.addUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
}
