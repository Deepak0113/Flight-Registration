package com.deepak.flightregistration.dto;

public class Credentials extends User {
    private String password;

    public Credentials(String userName, String email, String password){
        super.setEmail(email);
        super.setUsername(userName);
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
