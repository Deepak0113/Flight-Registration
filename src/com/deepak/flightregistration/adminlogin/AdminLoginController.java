package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;

public class AdminLoginController implements AdminLoginModelControllerCallback, AdminLoginViewControllerCallback {
    private AdminLoginViewCallback adminLoginView;
    private AdminLoginModelCallback adminLoginModel;

    AdminLoginController(AdminLoginViewCallback adminLoginView){
        this.adminLoginView = adminLoginView;
        adminLoginModel = new AdminLoginModel(this);
    }

    @Override
    public void adminLogin(String userName, String password){
        adminLoginModel.checkCredentials(userName, password);
    }

    @Override
    public void adminLoginSuccessful(User user){
        if(user.getUsername() == "admin"){
            adminLoginView.successfulAdminLogin(user);
        } else{
            adminLoginView.successfulUserLogin(user);
        }
    }

    @Override
    public void adminLoginFailed(String errorMessage){
        adminLoginView.failedLogin(errorMessage);
    }

}
