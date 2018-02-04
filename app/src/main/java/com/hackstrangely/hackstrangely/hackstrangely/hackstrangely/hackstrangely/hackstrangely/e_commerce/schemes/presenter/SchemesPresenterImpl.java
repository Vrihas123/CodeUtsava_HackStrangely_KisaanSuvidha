package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.provider.ProductProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.OnProductRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.ProductView;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model.SchemesList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.provider.SchemesProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view.OnSchemesRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view.SchemesView;

/**
 * Created by samveg on 25/8/17.
 */

public class SchemesPresenterImpl implements SchemesPresenter {

    SchemesView schemesView;
    SchemesProvider schemesProvider;

    public SchemesPresenterImpl(SchemesView schemesView, SchemesProvider schemesProvider) {
        this.schemesView = schemesView;
        this.schemesProvider = schemesProvider;
    }

    @Override
    public void requestSchemes(String access_token) {
        schemesView.showProgressBar(true);
        schemesProvider.requestSchemesProvider(access_token, new OnSchemesRecieved() {
            @Override
            public void onSuccess(SchemesList schemesList) {
                schemesView.showProgressBar(false);
                if (schemesList.isSuccess()){
                    schemesView.setData(schemesList.getData());
                }else{
                    schemesView.showMessage(schemesList.getMessage());
                }
            }

            @Override
            public void onFailure() {
                schemesView.showProgressBar(false);
                schemesView.showMessage("We cant connect to the server.Please check your internet connection");
            }
        });
    }
}
