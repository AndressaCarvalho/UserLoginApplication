package com.example.activityone.model;

public interface IUserModel {
    String getUserName();

    String getUserEmail();

    String getUserPassword();

    Boolean validateCredentials(String userNameEmail, String userPassword);
}
