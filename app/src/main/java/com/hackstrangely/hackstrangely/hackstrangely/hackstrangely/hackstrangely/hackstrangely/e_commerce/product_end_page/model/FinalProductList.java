package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model;

import java.util.List;

/**
 * Created by samveg on 3/2/18.
 */

public class FinalProductList {

    private List<FinalProductData> data;
    private boolean success;
    private String message;

    public List<FinalProductData> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public FinalProductList(List<FinalProductData> data, boolean success, String message) {

        this.data = data;
        this.success = success;
        this.message = message;
    }

}
