package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.provider.ProductProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.OnProductRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.ProductView;

/**
 * Created by samveg on 25/8/17.
 */

public class ProductPresenterImpl implements ProductPresenter {

    ProductView productView;
    ProductProvider productProvider;

    public ProductPresenterImpl(ProductView productView,ProductProvider productProvider) {
        this.productView = productView;
        this.productProvider = productProvider;
    }

    @Override
    public void requesCategory() {

        productView.showProgressBar(true);
        productProvider.requestCategory(new OnProductRecieved() {
            @Override
            public void onSuccess(ProductList productList) {
                productView.showProgressBar(false);
                if(productList.isSuccess()){
                    productView.setData(productList.getData());
                }
                else{
                    productView.showMessage(productList.getMessage());
                }

            }

            @Override
            public void onFailure() {
                productView.showProgressBar(false);
                productView.showMessage("We cant connect to our server.Please check your internet connection.");
            }
        });

    }
}
