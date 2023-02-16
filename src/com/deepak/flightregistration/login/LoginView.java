package com.deepak.flightregistration.login;

import com.deepak.flightregistration.dto.User;

import java.util.Scanner;

public class LoginView implements LoginViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private LoginViewControllerCallback loginController;

    public LoginView(){
        loginController = new LoginController(this);
    }

    private void getLoginDetails(){
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        loginController.userLogin(userName, password);
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.startLogin();
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
