package com.example.activityone.presenter;

import com.example.activityone.model.IUserModel;
import com.example.activityone.model.UserModel;
import com.example.activityone.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    private ILoginView loginView;
    private IUserModel user;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.user = new UserModel();
    }

    @Override
    public void doLogin(String userNameEmail, String userPassword) {
        loginView.onLoginResult(user.validateCredentials(userNameEmail, userPassword));
    }
}
