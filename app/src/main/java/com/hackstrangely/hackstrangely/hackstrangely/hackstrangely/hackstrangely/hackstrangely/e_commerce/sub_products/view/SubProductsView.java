package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsData;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubProductsView {

    void showProgressBar(boolean show);
    void setSubProductsData(List<SubProductsData> subProductsList);

}
