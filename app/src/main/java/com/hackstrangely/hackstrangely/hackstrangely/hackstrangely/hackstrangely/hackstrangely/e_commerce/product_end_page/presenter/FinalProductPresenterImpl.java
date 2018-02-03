package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model.FinalProductList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.provider.FinalProductProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view.FinalProductView;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view.OnFinalProductRecieved;

/**
 * Created by samveg on 3/2/18.
 */

public class FinalProductPresenterImpl implements FinalProductPresenter{


    FinalProductView finalProductView;
    FinalProductProvider finalProductProvider;

    public FinalProductPresenterImpl(FinalProductView finalProductView, FinalProductProvider finalProductProvider) {
        this.finalProductView = finalProductView;
        this.finalProductProvider = finalProductProvider;
    }

    @Override
    public void requestFinalProduct(String product_id, String access_token) {

        finalProductView.showProgressBar(true);
        finalProductProvider.requestFinalProductData(product_id, access_token, new OnFinalProductRecieved() {
            @Override
            public void onSuccess(FinalProductList finalProductList) {

                finalProductView.showProgressBar(false);
                if(finalProductList.isSuccess()){
                    finalProductView.setFinalProductData(finalProductList.getData());
                }

            }

            @Override
            public void onFailure() {

                finalProductView.showProgressBar(false);
            }
        });

    }
}
