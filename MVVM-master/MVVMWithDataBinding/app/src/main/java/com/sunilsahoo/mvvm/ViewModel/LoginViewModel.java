package com.sunilsahoo.mvvm.ViewModel;

import android.util.Log;

import com.sunilsahoo.mvvm.Model.LoginStatus;
import com.sunilsahoo.mvvm.Model.User;

/**
 * Created by sunilkumarsahoo on 9/3/16.
 */
public class LoginViewModel extends BaseViewModel {
    private static final String TAG = LoginViewModel.class.getName();
    private LoginStatus loginStatus;
    private User user;

    public LoginViewModel(OnViewModifiedListener onViewModifiedListener) {
        super(onViewModifiedListener);
        user = new User();
        loginStatus = new LoginStatus();
        this.loginStatus.register(this);
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public User getUser() {
        return user;
    }

    public void onLoginBtnClicked() {
        Log.d(TAG, "validate login from internet");
        //TODO
        Log.d(TAG, "update ui");
        loginStatus.setLoginStatus(user.getUserName().equals(user.getPassword
                ()));
    }
}
