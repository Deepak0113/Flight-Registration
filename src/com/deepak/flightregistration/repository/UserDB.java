package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.Credentials;
import com.deepak.flightregistration.dto.User;

import java.util.ArrayList;

public class UserDB {
    private static UserDB userDB;
    private ArrayList<Credentials> credentials = new ArrayList<>();

    public static UserDB getInstance(){
        if(userDB == null){
            userDB = new UserDB();
        }

        return userDB;
    }

    private void initSetup(){
        credentials.add(new Credentials("deepakm", "deepak@gmail.com", "deepakm"));
    }

    public User checkValidUser(String userName, String password){
        for(Credentials credential: credentials){
            if(credential.getUsername().equals(userName) && credential.getPassword().equals(password)){
                return credential;
            }
        }

        return null;
    }
}
