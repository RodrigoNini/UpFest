package com.UpFest.App.entities;

public class CarregamentoCashlessDTO {

    private String userEmail;
    private double value;

    public CarregamentoCashlessDTO(String userEmail, double value) {
        this.userEmail = userEmail;
        this.value = value;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
