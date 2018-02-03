package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorList;

import java.util.List;

/**
 * Created by samveg on 3/2/18.
 */

public interface CalculatorView {

    void showProgressBar(boolean show);
    void setFinalProductData(List<CalculatorData> calculatorData);

}
