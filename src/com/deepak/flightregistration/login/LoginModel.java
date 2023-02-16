package com.deepak.flightregistration.login;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.repository.Repository;

public class LoginModel implements LoginModelCallback {
    private LoginModelControllerCallback loginController;

    LoginModel(LoginModelControllerCallback loginController){
        this.loginController = loginController;
    }


    @Override
    public void checkCredentials(String userName, String password) {
        User user = Repository.getInstance().checkValidUser(userName, password);

        if(user != null){
            loginController.userLoginSuccessful(user);
        } else{
            loginController.userLoginFailed("error message");
        }
    }
}
