package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.api.RequestLogin;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.RegisterCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.api.RequestRegisterApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 1/2/18.
 */

public class RetrofitRegisterHelper implements RegisterBaseClassHelper{

    private static String TAG ="RetrofitRegisterHelper";


    @Override
    public void registerData(String name, String mobile, String password, String email, final RegisterCallback registerCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestRegisterApi requestRegisterApi = retrofit.create(RequestRegisterApi.class);
        Call<RegisterDataResponse> call = requestRegisterApi.getJSON(name, mobile, password, email);
        call.enqueue(new Callback<RegisterDataResponse>() {
            @Override
            public void onResponse(Call<RegisterDataResponse> call, Response<RegisterDataResponse> response) {
                registerCallback.onRegisterSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RegisterDataResponse> call, Throwable t) {
                registerCallback.onRegisterFailure(t.getMessage());
            }
        });

    }
}
