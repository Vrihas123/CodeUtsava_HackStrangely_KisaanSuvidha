package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.provider;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.OtpVerificationCallback;

/**
 * Created by samveg on 30/7/17.
 */

public interface OtpVerifyHelperClass {

    void getOtpResponse(String otp, String mobile, OtpVerificationCallback otpVerificationCallback);
    void onDestroy();
}
