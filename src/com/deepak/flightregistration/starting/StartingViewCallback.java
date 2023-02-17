package com.deepak.flightregistration.starting;

public interface StartingViewCallback {
    void gotoAdminLogin();
    void gotoUserLogin();
    void gotoRegistration();
    void exitSystem();
    void optionInvalidSelection();
}