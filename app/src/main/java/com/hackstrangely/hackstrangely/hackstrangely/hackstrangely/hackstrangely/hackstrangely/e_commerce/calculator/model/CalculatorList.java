package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model;

import java.util.List;

/**
 * Created by samveg on 3/2/18.
 */

public class CalculatorList {

    private List<CalculatorData> data;
    private boolean success;
    private String message;

    public List<CalculatorData> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public CalculatorList(List<CalculatorData> data, boolean success, String message) {

        this.data = data;
        this.success = success;
        this.message = message;
    }

}
