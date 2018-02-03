package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by samveg on 25/8/17.
 */

public interface RequestCategoryApi {

    @GET(Urls.REQUEST_PRODUCTS)
    Call<ProductList> getProductData();
}
