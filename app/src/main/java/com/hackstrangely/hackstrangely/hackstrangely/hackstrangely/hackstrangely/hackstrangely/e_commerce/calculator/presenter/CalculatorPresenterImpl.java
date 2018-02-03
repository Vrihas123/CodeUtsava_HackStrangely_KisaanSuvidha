package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.provider.CalculatorProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.CalculatorView;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.OnCalculatedDataRecieved;

/**
 * Created by samveg on 3/2/18.
 */

public class CalculatorPresenterImpl implements CalculatorPresenter{

    CalculatorView calculatorView;
    CalculatorProvider calculatorProvider;

    public CalculatorPresenterImpl(CalculatorView calculatorView, CalculatorProvider calculatorProvider) {
        this.calculatorView = calculatorView;
        this.calculatorProvider = calculatorProvider;
    }

    @Override
    public void requestCalculator(String bedSize, String access_token, String bed_lines) {

        calculatorView.showProgressBar(true);
        calculatorProvider.requestCalculatedData(bedSize, access_token, bed_lines,new OnCalculatedDataRecieved() {
            @Override
            public void onSuccess(CalculatorList calculatorList) {

                calculatorView.showProgressBar(false);
                if(calculatorList.isSuccess()){
                    calculatorView.setFinalProductData(calculatorList.getData());
                }

            }

            @Override
            public void onFailure() {

                calculatorView.showProgressBar(false);
            }
        });

    }
}
