package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public class DiseaseList {
    private List<DiseaseData> disease;
    private boolean success;
    private String message;

    public DiseaseList(List<DiseaseData> disease, boolean success, String message) {
        this.disease = disease;
        this.success = success;
        this.message = message;
    }

    public List<DiseaseData> getDisease() {
        return disease;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
