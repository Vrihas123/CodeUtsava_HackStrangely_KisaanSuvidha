package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.view.OtpActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.model.RegisterDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.presenter.RegisterData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.presenter.RegisterDataImp;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.register.provider.RetrofitRegisterHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private EditText inputName,inputMobile,inputEmail,inputPassword,inputRetypePassword;
    private TextInputLayout inputLayoutName,inputLayoutMobile,inputLayoutPassword,inputLayoutRetypePassword,inputLayoutEmail;
    private Button btn_signup;
    private String name,mobile,password,repassword,email;
    private ProgressBar progressBar;
    private RegisterData registerData;
    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPrefs = new SharedPrefs(this);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputLayoutRetypePassword = (TextInputLayout) findViewById(R.id.input_layout_retypePassword) ;
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputName = (EditText) findViewById(R.id.input_name);
        inputMobile = (EditText) findViewById(R.id.input_mobile);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputRetypePassword = (EditText) findViewById(R.id.input_retypePassword);
        btn_signup = (Button) findViewById(R.id.btn_register);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar_register);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputMobile.addTextChangedListener(new MyTextWatcher(inputMobile));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
    }

    public void proceed_signup(View v){
        submit();
    }
    private void submit(){
        submitForm();
    }


    private void submitForm() {
        if (!validateName()) {
            return;
        }
        if (!validateMobile()){
            return;
        }
        if (!validatePassword()){
            return;
        }
        if (!validateRetypePassword()) {
            return;
        }
        if (!validateEmail()) {
            return;
        }
//        Toast.makeText(getApplicationContext(), "Registration Successfull!!", Toast.LENGTH_SHORT).show();
        registerData = new RegisterDataImp(new RetrofitRegisterHelper(),this);
        registerData.getRegisterData(name,mobile,password,email);
        hideKeyboard();
    }

    private boolean validateName(){
        name = inputName.getText().toString().trim();
        if (name.isEmpty()){
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        }else {
            inputLayoutName.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateMobile(){
        mobile = inputMobile.getText().toString().trim();
        if (mobile.isEmpty()){
            inputLayoutMobile.setError(getString(R.string.err_msg_mobile));
            requestFocus(inputMobile);
            return false;
        }else if (mobile.length()!=10){
            inputLayoutMobile.setError(getString(R.string.err_msg_mobile_digits));
            requestFocus(inputMobile);
            return false;
        }else {
            inputLayoutMobile.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePassword(){
        password = inputPassword.getText().toString().trim();
        if (password.isEmpty()){
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        }else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateRetypePassword(){
        repassword = inputRetypePassword.getText().toString().trim();
        if (repassword.isEmpty()){
            inputLayoutRetypePassword.setError("Enter this field");
            requestFocus(inputRetypePassword);
            return false;
        }else if (repassword.equals(password)){
            inputLayoutRetypePassword.setErrorEnabled(false);
        }else{
            inputLayoutRetypePassword.setError(getString(R.string.err_retype_password));
            requestFocus(inputRetypePassword);
            return false;
        }
        return true;
    }
    private boolean validateEmail(){
        email = inputEmail.getText().toString().trim();
        if (email.isEmpty() || emailInvalid(email)){
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        }else {
            inputLayoutRetypePassword.setErrorEnabled(false);
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

    public boolean emailInvalid(String email) {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        boolean a = matcher.matches();
        return !a;
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
    public void showRegisterStatus(RegisterDataResponse registerDataResponse) {
        Intent i = new Intent(RegisterActivity.this, OtpActivity.class);
        i.putExtra(Keys.KEY_MOBILE,mobile);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
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
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_mobile:
                    validateMobile();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
                case R.id.input_layout_retypePassword:
                    validateRetypePassword();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
            }
        }
    }


}
