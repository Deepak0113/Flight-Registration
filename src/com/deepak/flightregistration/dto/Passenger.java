package com.deepak.flightregistration.dto;

public class Passenger {
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private String nationality;
    private String aadhaarID;

    public Passenger(String name, String email, String gender, String phoneNumber, String nationality, String aadhaarID) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.aadhaarID = aadhaarID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
