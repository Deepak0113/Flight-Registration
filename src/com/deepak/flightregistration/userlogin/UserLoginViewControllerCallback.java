package com.deepak.flightregistration.userlogin;

public interface UserLoginViewControllerCallback {
    void userLogin(String userName, String password);
    void selectOption(int option);
}
