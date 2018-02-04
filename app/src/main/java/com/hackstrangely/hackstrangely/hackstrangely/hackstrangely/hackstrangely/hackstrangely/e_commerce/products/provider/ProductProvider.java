package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.OnProductRecieved;

/**
 * Created by samveg on 24/8/17.
 */

public interface ProductProvider {

    void requestCategory(String access_token,String language, OnProductRecieved onProductRecieved);

}
