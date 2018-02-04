package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model.SchemesData;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public interface SchemesView {

    void setData(List<SchemesData> schemesData);
    void showProgressBar(boolean show);
    void showMessage(String message);

}
