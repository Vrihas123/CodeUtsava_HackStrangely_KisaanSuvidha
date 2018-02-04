package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data;

/**
 * Created by vrihas on 6/21/2017.
 */

public class DiseaseData {
    String name;
    String prevention;
    String image;

    public DiseaseData(String name, String prevention, String image) {
        this.name = name;
        this.prevention = prevention;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getPrevention() {
        return prevention;
    }

    public String getImage() {
        return image;
    }
}
