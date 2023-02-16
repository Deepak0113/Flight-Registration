package com.deepak.flightregistration.adminlogin;

public interface AdminLoginModelCallback {
    void checkCredentials(String userName, String password);
}
