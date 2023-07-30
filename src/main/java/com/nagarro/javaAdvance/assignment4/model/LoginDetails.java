package com.nagarro.javaAdvance.assignment4.model;

import jakarta.validation.constraints.NotEmpty;

public class LoginDetails {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String pass;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
