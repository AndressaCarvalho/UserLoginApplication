package com.example.activityone.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class UserModel implements IUserModel {
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<UserModel> users;

    public UserModel() { }

    public UserModel(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getUserEmail() {
        return this.userEmail;
    }

    @Override
    public String getUserPassword() {
        return this.userPassword;
    }

    private List<UserModel> getAllUsers() {
        if (users == null) {
            users = new ArrayList<>();
            users.add(new UserModel("admin", "admin@mail.com", "pass@123"));
            users.add(new UserModel("user1", "user1@mail.com", "pass@123"));
            users.add(new UserModel("user2", "user2@mail.com", "pass@123"));
        }
        
        return users;
    }

    @Override
    public Boolean validateCredentials(String userNameEmail, String userPassword) {
        Boolean isLoginSuccess = false;

        if (userNameEmail == null || TextUtils.isEmpty(userNameEmail) || userPassword == null || TextUtils.isEmpty(userPassword)) {
            return isLoginSuccess;
        } else {
            for (UserModel u: getAllUsers()) {
                if ((userNameEmail.equals(u.getUserName()) || userNameEmail.equals(u.getUserEmail())) && userPassword.equals(u.getUserPassword())) {
                    isLoginSuccess = true;
                    break;
                }
            }
        }

        return isLoginSuccess;
    }
}
