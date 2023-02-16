package com.deepak.flightregistration.login;

import com.deepak.flightregistration.dto.User;

public class LoginController implements LoginModelControllerCallback, LoginViewControllerCallback{
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    LoginController(LoginViewCallback loginView){
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    @Override
    public void userLogin(String userName, String password){
        loginModel.checkCredentials(userName, password);
    }

    @Override
    public void userLoginSuccessful(User user){
        if(user.getUsername() == "admin"){
            loginView.successfulAdminLogin(user);
        } else{
            loginView.successfulUserLogin(user);
        }
    }

    @Override
    public void userLoginFailed(String errorMessage){
        loginView.failedLogin(errorMessage);
    }

}
