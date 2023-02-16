package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

public interface UserLoginModelControllerCallback {
    void userLoginSuccessful(User user);
    void userLoginFailed(String errorMessage);
}
