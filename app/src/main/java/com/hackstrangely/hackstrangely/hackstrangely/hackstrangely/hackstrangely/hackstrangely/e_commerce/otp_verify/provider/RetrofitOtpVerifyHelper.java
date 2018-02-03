package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.provider;



import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.OtpVerificationCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.api.RequestOtpVerify;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.model.OtpData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 30/7/17.
 */

public class RetrofitOtpVerifyHelper implements OtpVerifyHelperClass{

    private static String TAG = "RetrofitOtpVerifyHelper";
    private Call<OtpData> call;

    @Override
    public void getOtpResponse(final String otp, String mobile, final OtpVerificationCallback otpVerificationCallback) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        final RequestOtpVerify requestOtpVerify = retrofit.create(RequestOtpVerify.class);

        call = requestOtpVerify.getJson(otp, mobile);
        call.enqueue(new Callback<OtpData>() {
            @Override
            public void onResponse(Call<OtpData> call, Response<OtpData> response) {

                otpVerificationCallback.onOtpVerified(response.body());

            }

            @Override
            public void onFailure(Call<OtpData> call, Throwable t) {
                t.printStackTrace();
                otpVerificationCallback.onFailure(t.getMessage());
            }
        });

    }

    @Override
    public void onDestroy() {
        if(call!=null){
            call.cancel();
        }

    }
}
