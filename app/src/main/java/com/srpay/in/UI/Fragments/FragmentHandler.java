package com.srpay.in.UI.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


import com.srpay.in.R;
import com.srpay.in.UI.Fragments.Home.HomeFragment;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;

import java.io.Serializable;

/**
 * Created by Localadmin on 5/30/2018.
 */

public class FragmentHandler implements HomeFragment.OnFragmentInteractionListener {

    private Context context;
    private NavigationDrawer navigationDrawer;
    private String TAG=getClass().getSimpleName();
    private FragmentListener fragmentListener;
    private Fragments fragments;

    public FragmentHandler(Context context) {
        this.context=context;
        navigationDrawer=((NavigationDrawer)context);
        fragmentListener=((FragmentListener)context);
        fragments = new Fragments(this);
    }

    public void Build()
    {
        addFragment();
    }

    private void addFragment()
    {
        Log.e(TAG,"addFragment: ");
        getTransaction().add(R.id.frameContainer, HomeFragment.newInstance(this)).commit();
    }

    public void changeView(int fragment)
    {
        Fragment replacefragment= fragments.getFragment(fragment);
        getTransaction().replace(R.id.frameContainer,replacefragment).addToBackStack(checkBackStack(replacefragment)).commit();
    }

    private String checkBackStack(Fragment fragment) {
        boolean fragmentPopped = navigationDrawer.getSupportFragmentManager().popBackStackImmediate (fragment.getClass().getSimpleName(), 0);
        Log.e(TAG,"fragmentPopped: "+fragmentPopped+ fragment.getClass().getSimpleName());
        if (!fragmentPopped) //fragment not in back stack, create it.
            return fragment.getClass().getSimpleName();
        return null;
    }

    public FragmentTransaction getTransaction()
    {
        return navigationDrawer.getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void onHomeFragmentInteraction() {
        fragmentListener.onAddedFragment();
    }



    public interface FragmentListener
    {
        void onAddedFragment();
        void onReplaceFragment(int fragments);
    }
}
