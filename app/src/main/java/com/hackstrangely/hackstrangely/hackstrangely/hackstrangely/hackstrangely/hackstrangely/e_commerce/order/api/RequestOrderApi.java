package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.order.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.order.model.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 4/2/18.
 */

public interface RequestOrderApi {

    @GET(Urls.REQUEST_ORDER)
    Call<OrderList> getCalculatedData(@Query("access_token") String access_token, @Query("product_id") String product_id, @Query("quantity") String quantity, @Query("price") String price);


}
