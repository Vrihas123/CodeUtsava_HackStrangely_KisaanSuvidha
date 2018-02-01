package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.LoginCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model.LoginDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.provider.LoginBaseClassHelper;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.view.LoginView;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataImp implements LoginData {

    private LoginBaseClassHelper loginBaseClassHelper;
    private LoginView login;
    public LoginDataImp(LoginView login, LoginBaseClassHelper loginBaseClassHelper) {
        this.login = login;
        this.loginBaseClassHelper = loginBaseClassHelper;
    }


    @Override
    public void getLoginData(String name, String mobile, String email) {

        login.showProgressBar(true);
        loginBaseClassHelper.loginData(name,mobile,email,new LoginCallback() {
            @Override
            public void onLoginSuccess(LoginDataResponse loginResponse) {
                if(loginResponse.isSuccess()) {
                    login.showProgressBar(false);
                    login.showLoginStatus(loginResponse);
                }
                else{
                    login.showProgressBar(false);
                    login.showError(loginResponse.getMessage());
                }
            }
            @Override
            public void onLoginFailure(String error) {
                login.showError("Sorry!!Something went wrong");
                login.showProgressBar(false);
                login.checkNetwork();
            }
        });
    }
}
