package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;

public interface AdminLoginModelControllerCallback {
    void adminLoginSuccessful(User user);
    void adminLoginFailed(String errorMessage);
}
