package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.OnSubProductsRecieved;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubProductsProvider {

    void requestSubProductData(String product_type, String access_token, OnSubProductsRecieved onSubProductsRecieved);

}
