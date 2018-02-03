package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductList;

/**
 * Created by samveg on 24/8/17.
 */

public interface OnProductRecieved {

    void onSuccess(ProductList productList);
    void onFailure();

}
