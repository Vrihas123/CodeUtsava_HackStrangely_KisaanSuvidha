package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.OtpVerificationCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.model.OtpData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.provider.OtpVerifyHelperClass;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.otp_verify.view.OtpView;

/**
 * Created by samveg on 30/7/17.
 */

public class OtpVerifyPresenterImp implements OtpVerifyPresenter{

    private OtpView otpView;
    private OtpVerifyHelperClass otpVerifyHelperClass;

    public OtpVerifyPresenterImp(OtpView otpView, OtpVerifyHelperClass otpVerifyHelperClass) {
        this.otpView = otpView;
        this.otpVerifyHelperClass = otpVerifyHelperClass;
    }

    @Override
    public void otpData(final String otp, String mobile) {
        otpView.showProgressBar(true);
        otpVerifyHelperClass.getOtpResponse(otp, mobile,new OtpVerificationCallback() {
            @Override
            public void onOtpVerified(OtpData otpData) {

                if (otpData.isSuccess()) {
                    otpView.OtpStatus(otpData);

                } else {
                    otpView.showMessage(otpData.getMessage());
                    otpView.verify_bttn_clickable();
                }
                otpView.showProgressBar(false);
            }

            @Override
            public void onFailure(String error) {
                otpView.showProgressBar(false);
                otpView.showMessage("Sorry!!Something went wrong");
                otpView.checkNetwork();
            }
        });

    }

    @Override
    public void onDestroy() {
        if(otpVerifyHelperClass!=null){
            otpVerifyHelperClass.onDestroy();
        }
    }
}
