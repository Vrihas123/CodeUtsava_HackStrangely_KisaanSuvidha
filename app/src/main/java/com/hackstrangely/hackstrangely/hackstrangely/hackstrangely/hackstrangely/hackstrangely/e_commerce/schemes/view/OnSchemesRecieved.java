package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model.SchemesList;

/**
 * Created by samveg on 24/8/17.
 */

public interface OnSchemesRecieved {

    void onSuccess(SchemesList schemesList);
    void onFailure();

}
