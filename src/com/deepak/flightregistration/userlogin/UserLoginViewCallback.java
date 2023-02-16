package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

public interface UserLoginViewCallback {
    void successfulAdminLogin(User user);
    void successfulUserLogin(User user);
    void failedLogin(String failedMessage);
}
