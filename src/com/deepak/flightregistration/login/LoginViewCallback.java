package com.deepak.flightregistration.login;

import com.deepak.flightregistration.dto.User;

public interface LoginViewCallback {
    void successfulAdminLogin(User user);
    void successfulUserLogin(User user);
    void failedLogin(String failedMessage);
}
