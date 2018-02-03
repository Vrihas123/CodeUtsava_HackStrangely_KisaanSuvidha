package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.OnCalculatedDataRecieved;

/**
 * Created by samveg on 3/2/18.
 */

public interface CalculatorProvider {

    void requestCalculatedData(String bed_size, String access_token, String lines, OnCalculatedDataRecieved onCalculatedDataRecieved);

}
