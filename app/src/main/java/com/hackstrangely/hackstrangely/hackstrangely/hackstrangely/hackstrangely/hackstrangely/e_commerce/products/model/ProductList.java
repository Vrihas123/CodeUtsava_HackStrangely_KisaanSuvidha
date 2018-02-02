package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class ProductList {

    private List<ProductData> data;
    private boolean success;
    private String message;

    public List<ProductData> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ProductList(List<ProductData> data, boolean success, String message) {

        this.data = data;
        this.success = success;
        this.message = message;
    }
}
