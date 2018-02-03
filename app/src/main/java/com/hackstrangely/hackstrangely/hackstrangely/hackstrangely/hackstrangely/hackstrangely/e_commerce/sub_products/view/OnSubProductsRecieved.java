package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsList;

/**
 * Created by samveg on 26/8/17.
 */

public interface OnSubProductsRecieved {

    void onSuccess(SubProductsList subProductsList);
    void onFailure();

}
