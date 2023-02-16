package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.dto.Credentials;

import java.util.ArrayList;

public class Repository {
    private static Repository repository;

    private ArrayList<Credentials> credentials = new ArrayList<>();

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }

        return repository;
    }

    private void initSetup(){
        credentials.add(new Credentials("admin", "admin"));
        credentials.add(new Credentials("deepakm", "deepakm"));
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
