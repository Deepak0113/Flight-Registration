package com.deepak.flightregistration.status;

import com.deepak.flightregistration.dto.User;

public class UserStatusCalls {
    User user;
    String status;

    public UserStatusCalls(String status){
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }
}
