package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.OnProductRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view.OnSchemesRecieved;

/**
 * Created by samveg on 24/8/17.
 */

public interface SchemesProvider {

    void requestSchemesProvider(String access_token,OnSchemesRecieved onSchemesRecieved);

}
