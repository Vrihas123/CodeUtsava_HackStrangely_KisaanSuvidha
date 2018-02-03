package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;

/**
 * Created by vrihas on 1/2/18.
 */

public interface RegisterView {

    void showProgressBar(boolean show);
    void showRegisterStatus(RegisterDataResponse registerDataResponse);
    void showError(String message);
}
