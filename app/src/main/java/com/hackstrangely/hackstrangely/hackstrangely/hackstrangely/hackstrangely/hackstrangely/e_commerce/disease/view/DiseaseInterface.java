package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseList;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface DiseaseInterface {

    void setData(DiseaseList diseaseList);
    void showMessage(String message);
    void showProgressBar(boolean show);
    void showDefault(boolean show);
    //void checkNetwork();
}
