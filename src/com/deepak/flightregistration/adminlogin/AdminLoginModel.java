package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.repository.Repository;

public class AdminLoginModel implements AdminLoginModelCallback {
    private AdminLoginModelControllerCallback adminLoginController;

    AdminLoginModel(AdminLoginModelControllerCallback adminLoginController){
        this.adminLoginController = adminLoginController;
    }

    @Override
    public void checkCredentials(String userName, String password) {
        User user = Repository.getInstance().checkValidAdmin(userName, password);

        if(user != null){
            adminLoginController.adminLoginSuccessful(user);
        } else{
            adminLoginController.adminLoginFailed("error message");
        }
    }
}
