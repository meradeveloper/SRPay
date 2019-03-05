package com.srpay.in.Adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;

import com.srpay.in.R;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * Created by Localadmin on 6/4/2018.
 */

public class MainSliderAdapter extends SliderAdapter {

    private Context context;
    private int id;
    public MainSliderAdapter(Context context)
    {
        this.context=context;
        id = context.getResources().getIdentifier("image_place_holder", "drawable", context.getPackageName());
    }
    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg", id,id);
                break;
            case 1:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg",id,id);
                break;
            case 2:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png",id,id);
                break;
        }
    }
}
