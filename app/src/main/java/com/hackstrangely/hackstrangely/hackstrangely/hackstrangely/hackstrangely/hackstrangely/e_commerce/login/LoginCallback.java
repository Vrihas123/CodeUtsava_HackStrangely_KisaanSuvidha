package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);
}
