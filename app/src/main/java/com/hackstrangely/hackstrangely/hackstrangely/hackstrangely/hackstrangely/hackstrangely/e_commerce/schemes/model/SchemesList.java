package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class SchemesList {

    private List<SchemesData> schemes;
    private boolean success;
    private String message;

    public List<SchemesData> getData() {
        return schemes;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public SchemesList(List<SchemesData> schemes, boolean success, String message) {

        this.schemes = schemes;
        this.success = success;
        this.message = message;
    }
}
