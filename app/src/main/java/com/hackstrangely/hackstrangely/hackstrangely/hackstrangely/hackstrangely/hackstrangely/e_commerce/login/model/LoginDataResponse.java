package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataResponse {

    private boolean success;
    private String message;
    public LoginDataResponse(boolean success, String message)
    {
        this.message=message;
        this.success=success;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
