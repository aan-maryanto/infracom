package com.example.infracom.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.infracom.entity.Users;
import com.example.infracom.entity.UsersContact;
import com.example.infracom.repository.UsersContactRepository;
import com.example.infracom.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersContactRepository usersContactRepository;
    
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(String id) {
        return usersRepository.findById(id);
    }

    public Users addUsers(Users users) {
        return usersRepository.save(users);
    }

    public UsersContact addUsersContact(UsersContact usersContact) {
        return usersContactRepository.save(usersContact);
    }

    public List<UsersContact> getAllUsersContact() {
        return usersContactRepository.findAll();
    }

    public Optional<UsersContact> getUsersContactById(String id) {
        return usersContactRepository.findById(id);
    }

    @Transactional
    public void addUserToContact(String idUsers, String idContact) {
        Users users = usersRepository.findById(idUsers).orElseThrow(() -> new RuntimeException("Data with Id : "+idUsers+" Not Found"));
        UsersContact usersContact = usersContactRepository.findById(idContact).orElseThrow(() -> new RuntimeException("Data with Id : "+idContact+" Not Found"));
        usersContact.setUsers(users);
        usersContactRepository.save(usersContact);
    }

}
