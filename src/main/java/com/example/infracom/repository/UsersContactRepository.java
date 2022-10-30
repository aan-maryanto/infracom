package com.example.infracom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infracom.entity.UsersContact;

public interface UsersContactRepository extends JpaRepository<UsersContact, String> {    
}
