package com.deepak.flightregistration.adminlogin;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.setupflightlibrary.SetupFlightLibraryView;

import java.util.Scanner;

public class AdminLoginView implements AdminLoginViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private AdminLoginViewControllerCallback adminLoginController;

    public AdminLoginView(){
        adminLoginController = new AdminLoginController(this);
    }

    private void getLoginDetails(){
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        adminLoginController.adminLogin(userName, password);
    }

    public static void main(String[] args) {
        AdminLoginView adminLoginView = new AdminLoginView();
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

        SetupFlightLibraryView setupFlightLibraryView = new SetupFlightLibraryView();
        setupFlightLibraryView.startSetupFlightLibrary();
    }

    @Override
    public void failedLogin(String failedMessage) {
        System.out.println("Login failed. " + failedMessage);
        startLogin();
    }
}
