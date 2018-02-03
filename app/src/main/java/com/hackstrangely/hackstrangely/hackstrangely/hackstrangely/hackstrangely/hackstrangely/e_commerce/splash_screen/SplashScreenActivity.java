package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.splash_screen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.language_selecter.LanguageActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.view.LoginActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.view.RegisterActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPrefs sharedPrefs;
    private ImageView logo_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPrefs = new SharedPrefs(this);
        logo_img = (ImageView) findViewById(R.id.logo);
        Glide.with(this).load("https://i.pinimg.com/originals/d5/ca/f1/d5caf1736960cc9ff32692faff0ccb8b.png").into(logo_img);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!sharedPrefs.isRegistered()){
                    Intent i =new Intent(SplashScreenActivity.this, RegisterActivity.class);
                }
                else if (!sharedPrefs.isLoggedIn()){
                    Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                }else {
                    Intent i =new Intent(SplashScreenActivity.this,LanguageActivity.class);
                }
            }
        },3000);
    }
}
