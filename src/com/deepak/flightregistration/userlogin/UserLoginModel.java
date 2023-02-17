package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.repository.Repository;

public class UserLoginModel implements UserLoginModelCallback {
    private UserLoginModelControllerCallback userLoginController;

    UserLoginModel(UserLoginModelControllerCallback userLoginController){
        this.userLoginController = userLoginController;
    }

    @Override
    public void checkCredentials(String userName, String password) {
        User user = Repository.getInstance().checkValidUser(userName, password);

        if(user != null){
            userLoginController.userLoginSuccessful(user);
        } else{
            userLoginController.userLoginFailed("error message");
        }
    }
}
