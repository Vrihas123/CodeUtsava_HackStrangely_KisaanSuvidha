package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view.OnFinalProductRecieved;

/**
 * Created by samveg on 3/2/18.
 */

public interface FinalProductProvider {

    void requestFinalProductData(String product_id, String access_token, OnFinalProductRecieved onFinalProductRecieved);

}
