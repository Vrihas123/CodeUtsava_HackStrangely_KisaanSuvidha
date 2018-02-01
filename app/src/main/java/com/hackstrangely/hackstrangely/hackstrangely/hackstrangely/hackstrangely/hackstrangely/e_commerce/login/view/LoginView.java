package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showLoginStatus(LoginDataResponse loginDataResponse);
    void showError(String message);
    void checkNetwork();
}
