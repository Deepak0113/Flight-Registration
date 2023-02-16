package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;

public interface AdminLoginViewCallback {
    void successfulAdminLogin(User user);
    void successfulUserLogin(User user);
    void failedLogin(String failedMessage);
}
