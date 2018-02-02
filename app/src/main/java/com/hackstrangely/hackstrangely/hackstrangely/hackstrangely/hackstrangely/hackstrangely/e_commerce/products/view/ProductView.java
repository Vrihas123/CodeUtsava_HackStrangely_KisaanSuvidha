package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductData;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public interface ProductView {

    void setData(List<ProductData> categoryDatas);
    void showProgressBar(boolean show);
    void showMessage(String message);

}
