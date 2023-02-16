package com.deepak.flightregistration.dto;

public class Credentials extends User {
    private String password;

    public Credentials(String userName, String password){
        super.setUsername(userName);
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
