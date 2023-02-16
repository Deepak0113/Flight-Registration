package com.deepak.flightregistration.login;

public interface LoginModelCallback {
    void checkCredentials(String userName, String password);
}
