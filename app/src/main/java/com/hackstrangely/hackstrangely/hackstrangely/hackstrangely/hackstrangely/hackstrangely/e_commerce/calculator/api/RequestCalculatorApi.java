package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 3/2/18.
 */

public interface RequestCalculatorApi {

    @GET(Urls.REQUEST_CALCULATOR)
    Call<CalculatorList> getCalculatedData(@Query("bed_size") String size, @Query("access_token") String access_token, @Query("beds_lines") String line, @Query("crop") String crop);

}
