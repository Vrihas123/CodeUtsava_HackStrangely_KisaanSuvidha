package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;

/**
 * Created by vrihas on 1/2/18.
 */

public interface RegisterCallback {
    void onRegisterSuccess(RegisterDataResponse registerDataResponse);
    void onRegisterFailure(String error);
}
