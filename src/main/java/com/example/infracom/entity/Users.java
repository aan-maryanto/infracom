package com.example.infracom.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Users implements Serializable {
    
    @Id
    private String Id;
    private String Name;
    private int Age;

    public Users(String Id, String Name, int Age) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
    }

    public Users() {}

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        this.Age = age;
    }

    @Override
    public String toString() {
        return "Users [Id=" + Id + ", name=" + Name + ", age=" + Age + "]";
    }

}
