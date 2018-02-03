package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.view;

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
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.Keys;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.model.OtpData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.presenter.OtpVerifyPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.presenter.OtpVerifyPresenterImp;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.provider.RetrofitOtpVerifyHelper;

public class OtpActivity extends AppCompatActivity implements OtpView{

    private TextInputLayout inputLayoutOtp;
    private EditText inputOtp;
    private Button btn_send_otp;
    private String otp,mobile;
    private ProgressBar progressBar;
    private SharedPrefs sharedPrefs;
    private OtpVerifyPresenter otpVerifyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        sharedPrefs = new SharedPrefs(this);
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            mobile = bundle.getString(Keys.KEY_MOBILE);
        }

        inputLayoutOtp = (TextInputLayout) findViewById(R.id.input_layout_otp);
        inputOtp = (EditText) findViewById(R.id.input_otp);
        btn_send_otp = (Button) findViewById(R.id.sendOtp);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar_otp);

        inputOtp.addTextChangedListener(new MyTextWatcher(inputOtp));
    }
    public void proceed_otp(View v){
        submit();
    }
    public void submit(){
        if (!validateOtp()){
            return;
        }
        otpVerifyPresenter = new OtpVerifyPresenterImp(this,new RetrofitOtpVerifyHelper());
        otpVerifyPresenter.otpData(otp,mobile);
        hideKeyboard();
    }
    public boolean validateOtp(){
        otp = inputOtp.getText().toString().trim();
        if (otp.isEmpty()){
            inputLayoutOtp.setError(getString(R.string.err_msg_otp));
            requestFocus(inputOtp);
        }else {
            inputLayoutOtp.setErrorEnabled(false);
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
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OtpStatus(OtpData otpData) {
        Intent i = new Intent(this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        sharedPrefs.setRegister(true);
        sharedPrefs.setAccessToken(otpData.getAccess_token());
        finish();
    }

    @Override
    public void checkNetwork() {

    }

    @Override
    public void verify_bttn_clickable() {

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
                case R.id.input_otp:
                    validateOtp();
                    break;
            }
        }
    }

}
