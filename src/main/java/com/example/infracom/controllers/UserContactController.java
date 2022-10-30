package com.example.infracom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.infracom.entity.Users;
import com.example.infracom.entity.UsersContact;
import com.example.infracom.services.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/userscontact")
public class UserContactController {

    @Autowired
    private UsersService usersService;
    
    @GetMapping("/list")
    public ResponseEntity<?> usersContacts() {
        List<UsersContact> usersContacts = usersService.getAllUsersContact();
        return ResponseEntity.ok().body(usersContacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> usersContact(@PathVariable String id) {
        UsersContact usersContact = usersService.getUsersContactById(id).orElseThrow(() -> new RuntimeException("Data Not Found"));
        return ResponseEntity.ok().body(usersContact);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUsersContact(@RequestBody UsersContact usersContact) {   
        Users users = usersContact.getUsers();
        UsersContact userContact = new UsersContact(usersContact.getId(), usersContact.getAddress(), null);
        Users u1 =  usersService.addUsers(users);
        UsersContact contact1 = usersService.addUsersContact(userContact);
        usersService.addUserToContact(u1.getId(), contact1.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body("sukses");
    }
    

}
