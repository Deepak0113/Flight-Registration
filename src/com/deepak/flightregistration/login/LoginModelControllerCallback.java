package com.deepak.flightregistration.login;

import com.deepak.flightregistration.dto.User;

public interface LoginModelControllerCallback {
    void userLoginSuccessful(User user);
    void userLoginFailed(String errorMessage);
}
