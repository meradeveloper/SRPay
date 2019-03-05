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

package com.srpay.in.UI.Recharge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;

import com.srpay.in.BR;
import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.DTH.DTHActivity;
import com.srpay.in.UI.NetworkOperator.OperatorActivity;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;
import com.srpay.in.databinding.ActivityRechargeBinding;

import javax.inject.Inject;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class RechargeActivity extends BaseActivity<ActivityRechargeBinding, RechargeViewModel> implements RechargeNavigator {


    @Inject
    RechargeViewModel mRechargeViewModel;
    private ActivityRechargeBinding  mActivityRechargeBinding;
    private Animation animation;

    public static Intent newIntent(Context context) {
        return new Intent(context, RechargeActivity.class);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {
        mActivityRechargeBinding = getViewDataBinding();
        if(bundle!=null)
        {
            RechargeConfig.TYPE=bundle.getString(RechargeConfig.TYPE);
            if(RechargeConfig.TYPE.equalsIgnoreCase(RechargeConfig.Type.PREPAID.toString()))
            {
                mActivityRechargeBinding.tvHeading.setText(RechargeConfig.PrepaidHeadingText);
                mActivityRechargeBinding.btn.setText(RechargeConfig.PrepaidButtonText);
            }
            else
            {
                mActivityRechargeBinding.tvHeading.setText(RechargeConfig.PostpaidHeadingText);
                mActivityRechargeBinding.btn.setText(RechargeConfig.PostpaidButtonText);
            }
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    public RechargeViewModel getViewModel() {
        return mRechargeViewModel;
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
        Intent intent = new Intent(RechargeActivity.this,NavigationDrawer.class);
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
        startActivityForResult(new Intent(RechargeActivity.this, OperatorActivity.class), 1);
        // startActivity(new Intent(DTHActivity.this, OperatorActivity.class));
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("Operator");
                mActivityRechargeBinding.operatorEditText.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRechargeViewModel.setNavigator(this);
    }
}
