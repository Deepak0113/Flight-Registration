package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.repository.Repository;
import com.deepak.flightregistration.status.UserStatusCalls;

public class UserLoginModel implements UserLoginModelCallback {
    private final UserLoginModelControllerCallback userLoginController;

    UserLoginModel(UserLoginModelControllerCallback userLoginController){
        this.userLoginController = userLoginController;
    }

    @Override
    public void checkCredentials(String userName, String password) {
        UserStatusCalls userStatusCall = Repository.getInstance().checkValidUser(userName, password);

        switch (userStatusCall.getStatus()){
            case "SUCCESS" -> userLoginController.userLoginSuccessful(userStatusCall.getUser());
            case "PASSWORD NOT MATCH" -> userLoginController.userLoginFailed("Password Incorrect");
            case "NOT EXISTS" -> userLoginController.userLoginFailed("Invalid username. user doesn't exist");
        }
    }
}
