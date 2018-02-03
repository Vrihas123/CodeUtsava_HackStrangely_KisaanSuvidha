package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model.FinalProductList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 3/2/18.
 */

public interface RequestProductApi {

    @GET(Urls.REQUEST_FINAL_PRODUCT)
    Call<FinalProductList> getFinalProduct(@Query("product_id") String ProductID, @Query("access_token") String access_token);


}
