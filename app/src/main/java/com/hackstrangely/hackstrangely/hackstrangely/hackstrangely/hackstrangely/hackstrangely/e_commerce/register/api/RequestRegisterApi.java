package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by vrihas on 1/2/18.
 */

public interface RequestRegisterApi {
    @FormUrlEncoded
    @POST(Urls.REQUEST_REGISTER)
    Call<RegisterDataResponse> getJSON(@Field("name") String name, @Field("contact_no") String mobile,@Field("password") String password, @Field("email") String email);
}
