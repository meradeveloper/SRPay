package com.srpay.in.UI.SideNavigation;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.srpay.in.BR;
import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.Fragments.FragmentHandler;
import com.srpay.in.UI.Fragments.Fragments;
import com.srpay.in.databinding.NavigationDrawerBinding;
import com.srpay.in.di.builder.ActivityBuilder_BindNavigationActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class NavigationDrawer extends BaseActivity<NavigationDrawerBinding,NavigationViewModel> implements NavigationView.OnNavigationItemSelectedListener,Drawer.DrawerAnimation,FragmentHandler.FragmentListener, HasSupportFragmentInjector {

    private FrameLayout FrameContainer;
    private CoordinatorLayout content;
    private FragmentHandler fragmentHandler;
    private String TAG=getClass().getSimpleName();
    private NavigationDrawerBinding mDrawerBinding;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    NavigationViewModel mViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.navigation_drawer;
    }

    @Override
    public NavigationViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         mDrawerBinding = getViewDataBinding();
         //mViewModel.setNavigator(this);
        initUI();
        if (FrameContainer != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentHandler=new FragmentHandler(this);
            fragmentHandler.Build();
        }
    }

    private void initUI() {
        content = findViewById(R.id.appBarNavigation);
        FrameContainer= findViewById(R.id.frameContainer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerBinding.navView.setItemIconTintList(null);
        mDrawerBinding.drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        Drawer drawer = new Drawer(this,mDrawerBinding.drawerLayout,toolbar);
        mDrawerBinding.drawerLayout.addDrawerListener(drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer.syncState();
        mDrawerBinding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            Log.e(TAG,"count: "+getSupportFragmentManager().getBackStackEntryCount()+" immediate: "+getSupportFragmentManager().popBackStackImmediate());
            for (int entry = 0; entry < getSupportFragmentManager().getBackStackEntryCount(); entry++) {
                Log.i(TAG, "Found fragment: " + getSupportFragmentManager().getBackStackEntryAt(entry).getName());
            }
            getSupportFragmentManager().popBackStack();
            //getSupportFragmentManager().beginTransaction().commit();
        } else {
            //handle finish
            //finish(); // Closes app
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            if(!item.isChecked())
            fragmentHandler.changeView(Fragments.DETAIL);
        } else if (id == R.id.nav_about) {
        } else if (id == R.id.nav_profile) {
        } else if (id == R.id.nav_user) {
        } else if (id == R.id.nav_logout) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        mDrawerBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDrawerSlide(float translate, float scale) {
        content.setTranslationX(translate);
        content.setScaleX(scale);
        content.setScaleY(scale);
    }

    @Override
    public void onAddedFragment() {
        Log.e(TAG,"onAddedFragment");
    }

    @Override
    public void onReplaceFragment(int fragment) {
        Log.e(TAG,"onReplaceFragment "+fragment);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
