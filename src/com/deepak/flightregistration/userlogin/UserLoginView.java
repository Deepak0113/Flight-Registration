package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

import java.util.Scanner;

public class UserLoginView implements UserLoginViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private UserLoginViewControllerCallback userLoginController;

    public UserLoginView(){
        userLoginController = new UserLoginController(this);
    }

    private void getLoginDetails(){
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userLoginController.userLogin(userName, password);
    }

    public static void main(String[] args) {
        UserLoginView adminLoginView = new UserLoginView();
        adminLoginView.startLogin();
    }

    public void startLogin(){
        getLoginDetails();
    }

    @Override
    public void successfulAdminLogin(User user) {
        System.out.println("Welcome " + user.getUsername());
    }

    @Override
    public void successfulUserLogin(User user) {
        System.out.println("---> Welcome " + user.getUsername() + "<---");
        System.out.println("Thank you for logging in");
    }

    @Override
    public void failedLogin(String failedMessage) {
        System.out.println("Login failed. " + failedMessage);
        startLogin();
    }
}
