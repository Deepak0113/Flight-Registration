package com.deepak.flightregistration.userlogin;

public interface UserLoginModelCallback {
    void checkCredentials(String userName, String password);
}
