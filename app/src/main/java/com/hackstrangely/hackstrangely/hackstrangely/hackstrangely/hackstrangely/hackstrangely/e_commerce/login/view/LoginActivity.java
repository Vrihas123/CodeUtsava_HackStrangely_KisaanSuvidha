package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.model.LoginDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.presenter.LoginData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.presenter.LoginDataImp;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.login.provider.RetrofitLoginHelper;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText inputLoginMobile,inputLoginPassword;
    private TextInputLayout inputLayoutLoginMobile,inputLayoutLoginPassword;
    private Button btn_login;
    private String mobile,password;
    private ProgressBar progressBar;
    private SharedPrefs sharedPrefs;
    private LoginData loginData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefs = new SharedPrefs(this);

        inputLayoutLoginMobile = (TextInputLayout) findViewById(R.id.input_layout_login_mobile);
        inputLayoutLoginPassword = (TextInputLayout) findViewById(R.id.input_layout_login_password);
        inputLoginMobile = (EditText) findViewById(R.id.input_login_mobile);
        inputLoginPassword = (EditText) findViewById(R.id.input_login_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar_login);

        inputLoginMobile.addTextChangedListener(new MyTextWatcher(inputLoginMobile));
        inputLoginPassword.addTextChangedListener(new MyTextWatcher(inputLoginPassword));
    }
    public void proceed_login(){
        submit();
    }
    public void submit(){
        if (!validateMobile()){
            return;
        }
        if (!validatePassword()){
            return;
        }
        loginData = new LoginDataImp(this,new RetrofitLoginHelper());
        loginData.getLoginData(mobile,password,sharedPrefs.getAccessToken());
        hideKeyboard();
    }
    private boolean validateMobile(){
        mobile = inputLoginMobile.getText().toString().trim();
        if (mobile.isEmpty()){
            inputLayoutLoginMobile.setError(getString(R.string.err_msg_mobile));
            requestFocus(inputLoginMobile);
            return false;
        }else if (mobile.length()!=10){
            inputLayoutLoginMobile.setError(getString(R.string.err_msg_mobile_digits));
            requestFocus(inputLoginMobile);
            return false;
        }else {
            inputLayoutLoginMobile.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePassword(){
        password = inputLoginPassword.getText().toString().trim();
        if (password.isEmpty()){
            inputLayoutLoginPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputLoginPassword);
            return false;
        }else {
            inputLayoutLoginPassword.setErrorEnabled(false);
        }
        return true;
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoginStatus(LoginDataResponse loginDataResponse) {
            sharedPrefs.setLogin(true);
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkNetwork() {

    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_login_mobile:
                    validateMobile();
                    break;
                case R.id.input_login_password:
                    validatePassword();
                    break;
            }
        }
    }

}
