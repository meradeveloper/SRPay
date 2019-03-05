package com.srpay.in.UI.SideNavigation;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.srpay.in.R;


/**
 * Created by Localadmin on 5/30/2018.
 */

public class Drawer extends ActionBarDrawerToggle {
    private DrawerAnimation drawerAnimation;
    public Drawer(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar) {
        super(activity, drawerLayout,toolbar, R.string.open, R.string.close);
        drawerAnimation=(DrawerAnimation)activity;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        super.onDrawerSlide(drawerView, slideOffset);
        float slideX = drawerView.getWidth() * slideOffset;
        float min = 0.9f;
        float max = 1.0f;
        float scaleFactor = (max - ((max - min) * slideOffset));
        drawerAnimation.onDrawerSlide(slideX,scaleFactor);
    }

    public interface DrawerAnimation
    {
        void onDrawerSlide(float translate, float scale);
    }
}
