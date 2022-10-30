package com.example.infracom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.infracom.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    
}
