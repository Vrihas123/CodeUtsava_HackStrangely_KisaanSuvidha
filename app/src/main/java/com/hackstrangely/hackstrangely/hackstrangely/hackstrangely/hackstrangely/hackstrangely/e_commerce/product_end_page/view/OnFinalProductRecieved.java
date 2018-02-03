package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model.FinalProductList;

/**
 * Created by samveg on 3/2/18.
 */

public interface OnFinalProductRecieved {

    void onSuccess(FinalProductList finalProductList);
    void onFailure();

}
