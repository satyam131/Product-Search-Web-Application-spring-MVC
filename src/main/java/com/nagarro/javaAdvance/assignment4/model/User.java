package com.nagarro.javaAdvance.assignment4.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NotEmpty
    private String userId;

    @Pattern(regexp = "^(.+)@(.+)", message = "should be valid")
    private String email;

    @NotEmpty
    private String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
