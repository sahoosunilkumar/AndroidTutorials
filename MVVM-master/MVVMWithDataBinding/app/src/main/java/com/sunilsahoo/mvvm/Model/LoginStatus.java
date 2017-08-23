package com.sunilsahoo.mvvm.Model;

/**
 * Created by sunilkumarsahoo on 9/3/16.
 */
public class LoginStatus extends BaseModel {

    private boolean loginStatus;
    private String loginStatusMessage;

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
        setLoginStatusMessage();
    }

    public String getLoginStatusMessage() {
        return loginStatusMessage;
    }

    private void setLoginStatusMessage() {
        loginStatusMessage = isLoginStatus() ? "Login Successful" :
                "Createddential Is Invalid";
        notifyModelChange();
    }
}
