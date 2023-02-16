package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.repository.AdminDB;

public class AdminLoginModel implements AdminLoginModelCallback {
    private AdminLoginModelControllerCallback adminLoginController;

    AdminLoginModel(AdminLoginModelControllerCallback adminLoginController){
        this.adminLoginController = adminLoginController;
    }

    @Override
    public void checkCredentials(String userName, String password) {
        User user = AdminDB.getInstance().checkValidUser(userName, password);

        if(user != null){
            adminLoginController.adminLoginSuccessful(user);
        } else{
            adminLoginController.adminLoginFailed("error message");
        }
    }
}
