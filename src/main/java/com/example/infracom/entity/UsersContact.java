package com.example.infracom.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class UsersContact implements Serializable {

    @Id
    private String Id;
    private String Address;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    public UsersContact(String Id, String Address, Users pUsers) {
        this.Id = Id;
        this.Address = Address;
        this.users = pUsers;
    }

    public UsersContact(){}

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersContact [Id=" + Id + ", Address=" + Address + ", users=" + users + "]";
    }
    
}
