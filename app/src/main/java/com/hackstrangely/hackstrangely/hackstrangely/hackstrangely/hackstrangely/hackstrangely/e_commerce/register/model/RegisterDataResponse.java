package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model;

/**
 * Created by vrihas on 1/2/18.
 */

public class RegisterDataResponse {
    private boolean success;
    private String message;

    public RegisterDataResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
