package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.model;

/**
 * Created by samveg on 30/7/17.
 */

public class OtpData {

    private String message;
    private boolean success;
    private String access_token;
    public OtpData(String message, boolean success, String access_token)
    {
        this.message=message;
        this.success=success;
        this.access_token = access_token;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAccess_token() {
        return access_token;
    }
}
