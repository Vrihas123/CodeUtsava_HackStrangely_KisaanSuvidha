package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper;

import android.app.Application;
import android.content.Context;
import android.util.Log;

//import com.crashlytics.android.Crashlytics;
//import com.google.firebase.iid.FirebaseInstanceId;
//
//import io.fabric.sdk.android.Fabric;


/**
 * Created by vrihas on 6/21/2017.
 */

public class MyApplication extends Application {

    public static String fcm_token;
    private static Context context;

    @Override
    public void onCreate() {

        super.onCreate();
        context=this;
      //  Fabric.with(this, new Crashlytics());
//        FacebookSdk.sdkInitialize(getApplicationContext());
        //    fcm_token = FirebaseInstanceId.getInstance().getToken();
        Log.d("myapplication",""+fcm_token);
    }
    public static Context getContext() {
        return context;
    }
//    public static String getFcm()
//    {
//        return FirebaseInstanceId.getInstance().getToken();
//    }
}
