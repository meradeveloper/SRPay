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

package com.srpay.in.UI.DTH;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;

import com.srpay.in.BR;
import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.NetworkOperator.OperatorActivity;
import com.srpay.in.UI.Recharge.RechargeActivity;
import com.srpay.in.UI.Recharge.RechargeConfig;
import com.srpay.in.UI.Recharge.RechargeNavigator;
import com.srpay.in.UI.Recharge.RechargeViewModel;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;
import com.srpay.in.databinding.ActivityDthBinding;
import com.srpay.in.databinding.ActivityRechargeBinding;

import javax.inject.Inject;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class DTHActivity extends BaseActivity<ActivityDthBinding, DTHViewModel> implements DTHNavigator {


    @Inject
    DTHViewModel mDTHViewModel;
    private ActivityDthBinding  mActivityDTHBinding;
    private Animation animation;

    public static Intent newIntent(Context context) {
        return new Intent(context, DTHActivity.class);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {
        mActivityDTHBinding = getViewDataBinding();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dth;
    }

    @Override
    public DTHViewModel getViewModel() {
        return mDTHViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
        Log.e("login","Error: "+throwable);
    }

    @Override
    public void login() {

    }

    @Override
    public void openMainActivity() {
        Log.e("login","openMainActivity");
        Intent intent = new Intent(DTHActivity.this,NavigationDrawer.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBack() {
        onBackPressed();
    }

    @Override
    public void onPostpaidRecharge() {
        Log.e("Recharge","Postpaid");
    }

    @Override
    public void onPrepaidRecharge() {
        Log.e("Recharge","Prepaid");
    }

    @Override
    public void onSelectOperator() {
        startActivityForResult(new Intent(DTHActivity.this, OperatorActivity.class), 1);
       // startActivity(new Intent(DTHActivity.this, OperatorActivity.class));
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDTHViewModel.setNavigator(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onItemClick","click: "+requestCode+" result :"+resultCode+" resultok "+Activity.RESULT_OK);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("Operator");
                mActivityDTHBinding.operatorEditText.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
