package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseList;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface OnDiseaseReceived {

    void onSuccess(DiseaseList diseaseList);
    void onFailure();
}
