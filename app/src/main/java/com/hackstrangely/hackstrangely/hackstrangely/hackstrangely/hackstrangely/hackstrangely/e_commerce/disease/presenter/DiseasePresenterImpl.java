package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.DiseaseProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view.DiseaseInterface;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view.OnDiseaseReceived;

/**
 * Created by vrihas on 6/21/2017.
 */

public class DiseasePresenterImpl implements DiseasePresenter {

    private DiseaseProvider diseaseProvider;
    private DiseaseInterface diseaseInterface;

    public DiseasePresenterImpl(DiseaseProvider diseaseProvider, DiseaseInterface diseaseInterface) {
        this.diseaseProvider = diseaseProvider;
        this.diseaseInterface = diseaseInterface;
    }

    @Override
    public void requestDisease(String access_token) {
        diseaseInterface.showProgressBar(true);
        diseaseProvider.requestDisease(access_token, new OnDiseaseReceived() {
            @Override
            public void onSuccess(DiseaseList diseaseList) {
                diseaseInterface.showProgressBar(false);
                if (diseaseList.isSuccess()){
                    diseaseInterface.setData(diseaseList);
                }
                else {
                    diseaseInterface.showDefault(true);
                }

            }
            @Override
            public void onFailure() {
                diseaseInterface.showProgressBar(false);
                diseaseInterface.showMessage("Please check your internet connection");
//                blogsInterface.checkNetwork();
            }
        });
    }
}
