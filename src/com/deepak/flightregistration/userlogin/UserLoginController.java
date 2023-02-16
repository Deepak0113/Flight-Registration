package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

public class UserLoginController implements UserLoginModelControllerCallback, UserLoginViewControllerCallback {
    private UserLoginViewCallback userLoginView;
    private UserLoginModelCallback adminLoginModel;

    UserLoginController(UserLoginViewCallback userLoginView){
        this.userLoginView = userLoginView;
        adminLoginModel = new UserLoginModel(this);
    }

    @Override
    public void userLogin(String userName, String password){
        adminLoginModel.checkCredentials(userName, password);
    }

    @Override
    public void userLoginSuccessful(User user){
        if(user.getUsername() == "admin"){
            userLoginView.successfulAdminLogin(user);
        } else{
            userLoginView.successfulUserLogin(user);
        }
    }

    @Override
    public void userLoginFailed(String errorMessage){
        userLoginView.failedLogin(errorMessage);
    }

}
