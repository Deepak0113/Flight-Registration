package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

public interface UserLoginViewCallback {
    void getUserLoginDetails();
    void gotoStart();
    void invalidOption();

    void userLoginSuccessfulView(User user);
    void userLoginFailedView(String errorMessage);
}
