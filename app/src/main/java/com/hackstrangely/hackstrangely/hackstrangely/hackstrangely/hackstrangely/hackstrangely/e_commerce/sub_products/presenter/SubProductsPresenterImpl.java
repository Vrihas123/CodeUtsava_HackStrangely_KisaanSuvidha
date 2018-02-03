package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.provider.SubProductsProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.OnSubProductsRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.SubProductsView;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class SubProductsPresenterImpl implements SubProductsPresenter {

    SubProductsView subProductsView;
    SubProductsProvider subProductsProvider;

    public SubProductsPresenterImpl(SubProductsView subProductsView, SubProductsProvider subProductsProvider) {
        this.subProductsView = subProductsView;
        this.subProductsProvider = subProductsProvider;
    }


    @Override
    public void requestSubProducts(String product_type, String access_token) {
        subProductsView.showProgressBar(true);
        subProductsProvider.requestSubProductData(product_type, access_token, new OnSubProductsRecieved() {
            @Override
            public void onSuccess(SubProductsList subProductsList) {
                subProductsView.showProgressBar(false);
                if (subProductsList.isSuccess()){
                    subProductsView.setSubProductsData(subProductsList.getGet_products());
                }

            }

            @Override
            public void onFailure() {
                subProductsView.showProgressBar(false);
            }
        });
    }
}
