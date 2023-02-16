package com.deepak.flightregistration.dto;

public class User {
    private String username;
    private String email;

    void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return username + " " + email;
    }
}
