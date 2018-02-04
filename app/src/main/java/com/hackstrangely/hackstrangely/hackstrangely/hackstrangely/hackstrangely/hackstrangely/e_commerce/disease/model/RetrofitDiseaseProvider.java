package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.api.RequestInterface;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view.OnDiseaseReceived;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 6/21/2017.
 */

public class RetrofitDiseaseProvider implements DiseaseProvider {

    private static final String TAG = "Retrofit Blogs Provider";

    @Override
    public void requestDisease(String access_token, final OnDiseaseReceived onDiseaseReceived) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        //.addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache())

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final RequestInterface request = retrofit.create(RequestInterface.class);


        Call<DiseaseList> call = request.getDisease(access_token);

        call.enqueue(new Callback<DiseaseList>(){
            @Override
            public void onResponse(Call<DiseaseList> call, Response<DiseaseList> response) {
                onDiseaseReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DiseaseList> call, Throwable t) {
                Log.d("Response","Fail");
                t.printStackTrace();
                onDiseaseReceived.onFailure();
            }
        });
    }
}
