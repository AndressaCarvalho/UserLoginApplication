package com.example.activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityone.presenter.ILoginPresenter;
import com.example.activityone.presenter.LoginPresenter;
import com.example.activityone.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private TextView userNameEmail;
    private TextView userPassword;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);

        findViewById(R.id.logIn).setOnClickListener(view -> {
            userNameEmail = findViewById(R.id.userNameEmail);
            userPassword = findViewById(R.id.userPassword);

            onLoginCall(userNameEmail.getText().toString(), userPassword.getText().toString());
        });
    }

    @Override
    public void onLoginCall(String userNameEmail, String userPassword) {
        loginPresenter.doLogin(userNameEmail, userPassword);
    }

    @Override
    public void onLoginResult(Boolean isResultSuccess) {
        if (isResultSuccess) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
        else {
            Toast.makeText(LoginActivity.this, "Login FAILED!", Toast.LENGTH_SHORT).show();
        }
    }
}