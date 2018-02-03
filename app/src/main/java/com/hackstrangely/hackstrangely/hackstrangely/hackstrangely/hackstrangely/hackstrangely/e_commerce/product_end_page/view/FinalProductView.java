package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.product_end_page.model.FinalProductData;

import java.util.List;

/**
 * Created by samveg on 3/2/18.
 */

public interface FinalProductView {

    void showProgressBar(boolean show);
    void setFinalProductData(List<FinalProductData> FinalProductList);

}
