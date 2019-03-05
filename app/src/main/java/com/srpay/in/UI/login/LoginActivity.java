/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.srpay.in.UI.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;
import com.srpay.in.databinding.ActivityLoginBinding;
import com.srpay.in.BR;
import com.srpay.in.utils.SecretKey;

import javax.inject.Inject;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {


    @Inject
    LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;
    private Animation animation;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
        Log.e("login","Error: "+throwable);
    }

    @Override
    public void login() {
        String email = mActivityLoginBinding.usernameEditText.getText().toString();
        String password = mActivityLoginBinding.passwordEditText.getText().toString();
        openMainActivity();
        //mLoginViewModel.login();
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(LoginActivity.this,NavigationDrawer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
        overridePendingTransition(0,0);
        animation= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        mActivityLoginBinding.loginContainer.startAnimation(animation);
    }
}
