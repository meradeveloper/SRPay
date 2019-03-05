package com.srpay.in.UI.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.srpay.in.BR;
import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.login.LoginActivity;
import com.srpay.in.databinding.ActivitySplashBinding;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashViewModel.SplashNavigator {

    private Animation hold ;
    private Animation translateScale ;
    private static int ACTIVITY_AUTH = 1000;
    private ActivitySplashBinding ASB;
    @Inject
    SplashViewModel splashViewModel;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return splashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ASB = getViewDataBinding();
        splashViewModel.setNavigator(this);
        getAnimation();
    }

    private void getAnimation()
    {
        ASB.shimmerViewContainer.startShimmerAnimation();
        hold = AnimationUtils.loadAnimation(this, R.anim.hold);

        /* Translates ImageView from current position to its original position, scales it from
        larger scale to its original scale.*/
        translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        translateScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getViewModel().getNavigator().onNavigate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ASB.shimmerViewContainer.clearAnimation();
                ASB.shimmerViewContainer.startAnimation(translateScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ASB.shimmerViewContainer.startAnimation(hold);
    }

    @Override
    public void onNavigate() {
        if (!getViewModel().isAuthenticated())
        {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }

        /*else
            startActivity(new Intent(SplashActivity.this, DashboardActivity.class));*/
    }
}
