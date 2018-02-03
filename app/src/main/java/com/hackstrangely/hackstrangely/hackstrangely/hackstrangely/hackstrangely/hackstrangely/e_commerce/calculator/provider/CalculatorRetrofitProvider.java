package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.api.RequestCalculatorApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.OnCalculatedDataRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;

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

public class CalculatorRetrofitProvider implements CalculatorProvider{


    private Retrofit retrofit;
    private RequestCalculatorApi requestCalculatorApi;
    Call<CalculatorList> call;

    @Override
    public void requestCalculatedData(String bed_size, String access_token, String lines, final OnCalculatedDataRecieved onCalculatedDataRecieved) {


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

        requestCalculatorApi = retrofit.create(RequestCalculatorApi.class);

        call = requestCalculatorApi.getCalculatedData(bed_size,access_token,lines);

        call.enqueue(new Callback<CalculatorList>() {
            @Override
            public void onResponse(Call<CalculatorList> call, Response<CalculatorList> response) {
                onCalculatedDataRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CalculatorList> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
