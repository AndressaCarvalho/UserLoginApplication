package com.example.activityone.view;

public interface ILoginView {
    void onLoginCall(String userNameEmail, String userPassword);

    void onLoginResult(Boolean isLoginSuccess);
}
