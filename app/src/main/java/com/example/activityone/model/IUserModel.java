package com.example.activityone.model;

import java.util.List;

public interface IUserModel {
    String getUserName();

    String getUserEmail();

    String getUserPassword();

    Boolean validateCredentials(String userNameEmail, String userPassword);
}
