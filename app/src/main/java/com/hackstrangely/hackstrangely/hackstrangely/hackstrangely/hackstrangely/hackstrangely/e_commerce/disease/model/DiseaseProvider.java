package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view.OnDiseaseReceived;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface DiseaseProvider {
    void requestDisease(String access_token, OnDiseaseReceived onDiseaseReceived);
}
