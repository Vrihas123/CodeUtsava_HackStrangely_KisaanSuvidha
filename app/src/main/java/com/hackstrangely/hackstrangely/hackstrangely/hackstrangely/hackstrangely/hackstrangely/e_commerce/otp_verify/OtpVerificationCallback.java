package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.model.OtpData;

/**
 * Created by samveg on 30/7/17.
 */

public interface OtpVerificationCallback {

    void onOtpVerified(OtpData otpData);
    void onFailure(String error);
}
