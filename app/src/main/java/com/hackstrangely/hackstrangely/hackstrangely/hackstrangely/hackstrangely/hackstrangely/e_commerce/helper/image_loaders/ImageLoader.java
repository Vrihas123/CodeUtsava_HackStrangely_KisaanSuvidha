package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.image_loaders;

import android.widget.ImageView;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by samveg on 25/6/17.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView, AVLoadingIndicatorView progressBar);
    void load_circular_image(String url, ImageView imageView, AVLoadingIndicatorView progressBar);

}
