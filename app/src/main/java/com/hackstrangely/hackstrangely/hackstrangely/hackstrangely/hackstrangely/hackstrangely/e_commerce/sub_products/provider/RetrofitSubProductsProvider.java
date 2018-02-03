package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.api.RequestSubProductsApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.OnSubProductsRecieved;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 26/8/17.
 */

public class RetrofitSubProductsProvider implements SubProductsProvider {

    private Retrofit retrofit;
    private RequestSubProductsApi requestSubProductsApi;
    Call<SubProductsList> call;

    @Override
    public void requestSubProductData(String product_type, String access_token, final OnSubProductsRecieved onSubProductsRecieved) {
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

        requestSubProductsApi = retrofit.create(RequestSubProductsApi.class);

        call = requestSubProductsApi.getsubProductsData(product_type,access_token );
        call.enqueue(new Callback<SubProductsList>() {
            @Override
            public void onResponse(Call<SubProductsList> call, Response<SubProductsList> response) {
                onSubProductsRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubProductsList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
