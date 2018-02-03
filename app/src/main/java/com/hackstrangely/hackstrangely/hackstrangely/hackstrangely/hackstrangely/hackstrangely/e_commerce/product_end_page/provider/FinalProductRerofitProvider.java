package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.api.RequestProductApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model.FinalProductList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view.OnFinalProductRecieved;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 3/2/18.
 */

public class FinalProductRerofitProvider implements FinalProductProvider{

    private Retrofit retrofit;
    private RequestProductApi requestProductApi;
    Call<FinalProductList> call;


    @Override
    public void requestFinalProductData(String product_id, String access_token, final OnFinalProductRecieved onFinalProductRecieved) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        requestProductApi = retrofit.create(RequestProductApi.class);

        call = requestProductApi.getFinalProduct(product_id,access_token);

        call.enqueue(new Callback<FinalProductList>() {
            @Override
            public void onResponse(Call<FinalProductList> call, Response<FinalProductList> response) {
                onFinalProductRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FinalProductList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
