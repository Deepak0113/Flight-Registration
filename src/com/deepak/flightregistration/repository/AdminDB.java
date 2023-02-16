package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.dto.Credentials;

import java.util.ArrayList;

public class AdminDB {
    private static AdminDB adminDB;
    private ArrayList<Credentials> credentials = new ArrayList<>();

    public static AdminDB getInstance(){
        if(adminDB == null){
            adminDB = new AdminDB();
            adminDB.initSetup();
        }

        return adminDB;
    }

    private void initSetup(){
        credentials.add(new Credentials("admin", "admin@gmail.com" , "admin"));
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
