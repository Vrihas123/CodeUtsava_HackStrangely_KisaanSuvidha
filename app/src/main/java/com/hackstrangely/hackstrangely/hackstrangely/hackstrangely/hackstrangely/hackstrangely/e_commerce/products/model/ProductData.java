package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model;

/**
 * Created by samveg on 24/8/17.
 */

public class ProductData {

    String product_type;
    String image_url;

    public ProductData(String product_type, String image_url) {
        this.product_type = product_type;
        this.image_url = image_url;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getImage_url() {
        return image_url;
    }

}
