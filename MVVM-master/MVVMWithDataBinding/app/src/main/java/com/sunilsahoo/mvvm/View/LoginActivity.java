package com.sunilsahoo.mvvm.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sunilsahoo.mvvm.R;
import com.sunilsahoo.mvvm.ViewModel.LoginViewModel;
import com.sunilsahoo.mvvm.ViewModel.OnViewModifiedListener;

public class LoginActivity extends AppCompatActivity implements
        OnClickListener, OnViewModifiedListener {


    private static final String TAG = LoginActivity.class.getName();
    private EditText userNameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView loginStatusTV;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(this);
        userNameET = (EditText) findViewById(R.id.username);
        passwordET = (EditText) findViewById(R.id.password);
        loginStatusTV = (TextView) findViewById(R.id.loginstatus);
        loginViewModel = new LoginViewModel(this);
        loginStatusTV.setText(loginViewModel.getLoginStatus()
                .getLoginStatusMessage());
    }

    @Override
    public void onClick(View view) {
        loginViewModel.getUser().setUserName(userNameET.getText().toString());
        loginViewModel.getUser().setPassword(passwordET.getText().toString());
        loginViewModel.onLoginBtnClicked();
    }

    @Override
    public void onViewModified(boolean userAction) {
        Log.d(TAG, "onViewModified : " + userAction);
        loginStatusTV.setText(loginViewModel.getLoginStatus()
                .getLoginStatusMessage());
    }
}
