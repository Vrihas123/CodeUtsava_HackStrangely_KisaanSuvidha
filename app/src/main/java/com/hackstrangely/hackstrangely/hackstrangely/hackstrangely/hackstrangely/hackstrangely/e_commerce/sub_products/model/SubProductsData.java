package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model;

/**
 * Created by samveg on 26/8/17.
 */

public class SubProductsData {

    String product_id,product_name,product_image,product_price;

    public SubProductsData(String product_id, String product_name, String product_image, String product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_image = product_image;
        this.product_price = product_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public String getProduct_price() {
        return product_price;
    }
}
