package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorList;

/**
 * Created by samveg on 3/2/18.
 */

public interface OnCalculatedDataRecieved {

    void onSuccess(CalculatorList calculatorList);
    void onFailure();

}
