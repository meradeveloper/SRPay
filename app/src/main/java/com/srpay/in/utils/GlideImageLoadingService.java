package com.srpay.in.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import ss.com.bannerslider.ImageLoadingService;

/**
 * Created by Localadmin on 6/4/2018.
 */

public class GlideImageLoadingService implements ImageLoadingService {
    public Context context;

    public GlideImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    @Override
    public void loadImage(int resource, ImageView imageView) {
        Glide.with(context)
                .load(resource)
                .into(imageView);
    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(placeHolder);
        requestOptions.error(errorDrawable);
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions)
                .asGif()
                .load(url)
                .into(imageView);
    }
}
