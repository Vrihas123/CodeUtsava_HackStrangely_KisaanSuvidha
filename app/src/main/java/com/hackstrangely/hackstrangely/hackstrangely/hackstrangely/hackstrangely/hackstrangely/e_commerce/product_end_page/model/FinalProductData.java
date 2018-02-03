package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model;


import java.util.List;

/**
 * Created by samveg on 3/2/18.
 */

public class FinalProductData {

    String product_name;
    String image_url;
    String product_details;
    String product_price;
    String product_quantity;




    public FinalProductData(String product_name, String image_url, String product_details, String product_price, String product_quantity) {
        this.product_name = product_name;
        this.image_url = image_url;
        this.product_details = product_details;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
    }

    public String getProduct_details() {
        return product_details;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public String getProduct_name() {
        return product_name;

    }

    public String getImage_url() {
        return image_url;
    }

}
