package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.language_selecter;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.view.LoginActivity;

import java.util.Locale;

import butterknife.BindView;

public class LanguageActivity extends AppCompatActivity {

    private RadioGroup radioGroup_language;
    private RadioButton radio_en,radio_hi;
    private Button btn_lang;
    private SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        sharedPrefs = new SharedPrefs(this);
//        radio_en = (RadioButton) findViewById(R.id.english_radio_btn);
//        radio_hi = (RadioButton) findViewById(R.id.hindi_radio_btn);
        btn_lang = (Button) findViewById(R.id.btn_lang);
        radioGroup_language = (RadioGroup) findViewById(R.id.language_radio_group);
        radioGroup_language.clearCheck();
        radioGroup_language.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null!=rb && checkedId>-1){
                    if (checkedId == R.id.english_radio_btn){
                        sharedPrefs.setKeyLanguage("1");
                        Locale locale = new Locale("en");
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                      }else{
                        sharedPrefs.setKeyLanguage("2");
                        Locale locale2 = new Locale("hi");
                        Locale.setDefault(locale2);
                        Configuration config = new Configuration();
                        config.locale = locale2;
                        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                    }

                    }
                }
        });
        btn_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LanguageActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });


    }
}
