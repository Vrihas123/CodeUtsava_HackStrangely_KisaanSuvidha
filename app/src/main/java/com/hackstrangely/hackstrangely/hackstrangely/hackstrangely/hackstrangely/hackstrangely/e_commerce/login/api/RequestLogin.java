package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.api;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model.LoginDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 30/7/17.
 */

public interface RequestLogin {

    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginDataResponse> getJSON(@Field("contact_no") String mobile, @Field("password") String password, @Field("access_token") String access_token);
}
