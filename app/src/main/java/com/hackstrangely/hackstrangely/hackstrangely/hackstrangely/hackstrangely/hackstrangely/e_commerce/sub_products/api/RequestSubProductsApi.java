package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.api;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 26/8/17.
 */

public interface RequestSubProductsApi {

    @GET(Urls.REQUEST_SUB_PRODUCTS)
    Call<SubProductsList> getsubProductsData(@Query("product_type") String product_type, @Query("access_token") String access_token);

}
