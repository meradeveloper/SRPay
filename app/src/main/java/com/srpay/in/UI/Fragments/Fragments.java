package com.srpay.in.UI.Fragments;

import android.support.v4.app.Fragment;

import com.srpay.in.UI.Fragments.Home.HomeFragment;

/**
 * Created by Localadmin on 5/31/2018.
 */

public class Fragments {

    public static int HOME=0;
    public static int DETAIL=1;
    private FragmentHandler fragmentHandler;

    public Fragments(FragmentHandler fragmentHandler) {
        this.fragmentHandler=fragmentHandler;
    }

    public Fragment getFragment(int fragment)
    {
        /*if(fragment==DETAIL)
            return DetailFragment.newInstance(fragmentHandler);
        else if (fragment==HOME)
            return DetailFragment.newInstance(fragmentHandler);*/

        return HomeFragment.newInstance(fragmentHandler);
    }
}
