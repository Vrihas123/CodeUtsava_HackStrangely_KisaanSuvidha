package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class SubProductsList {

    boolean success;
    String message;
    private List<SubProductsData> get_products;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SubProductsData> getGet_products() {
        return get_products;
    }

    public SubProductsList(boolean success, String message, List<SubProductsData> get_products) {

        this.success = success;
        this.message = message;
        this.get_products = get_products;
    }
}
