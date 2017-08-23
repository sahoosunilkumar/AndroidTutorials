package com.sunilsahoo.mvvm.Model;

/**
 * Created by sunilkumarsahoo on 9/3/16.
 */
public class User extends BaseModel {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
