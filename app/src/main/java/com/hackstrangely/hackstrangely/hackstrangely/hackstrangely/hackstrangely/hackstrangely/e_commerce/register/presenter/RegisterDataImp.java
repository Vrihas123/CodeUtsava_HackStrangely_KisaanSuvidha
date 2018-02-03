package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.RegisterCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.provider.RegisterBaseClassHelper;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.view.RegisterView;

/**
 * Created by vrihas on 1/2/18.
 */

public class RegisterDataImp implements RegisterData{
    private RegisterBaseClassHelper registerBaseClassHelper;
    private RegisterView registerView;

    public RegisterDataImp(RegisterBaseClassHelper registerBaseClassHelper, RegisterView registerView) {
        this.registerBaseClassHelper = registerBaseClassHelper;
        this.registerView = registerView;
    }

    @Override
    public void getRegisterData(String name, String mobile, String password, String email) {
        registerView.showProgressBar(true);
        registerBaseClassHelper.registerData(name, mobile, password, email, new RegisterCallback() {
            @Override
            public void onRegisterSuccess(RegisterDataResponse registerDataResponse) {
                if (registerDataResponse.isSuccess()){
                    registerView.showProgressBar(false);
                    registerView.showRegisterStatus(registerDataResponse);
                }else {
                    registerView.showProgressBar(true);
                    registerView.showError(registerDataResponse.getMessage());
                }
            }

            @Override
            public void onRegisterFailure(String error) {
                registerView.showProgressBar(false);
                registerView.showError("Sorry!!Something went wrong");
            }
        });
    }
}
