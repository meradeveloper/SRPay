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

package com.srpay.in.UI.NetworkOperator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.animation.Animation;

import com.srpay.in.Adapters.CustomRecycleAdapter;
import com.srpay.in.BR;
import com.srpay.in.Base.BaseActivity;
import com.srpay.in.R;
import com.srpay.in.UI.Fragments.Home.HomeOptionModel;
import com.srpay.in.UI.RecycleView.ItemOffsetDecoration;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;
import com.srpay.in.databinding.ActivityOperatorBinding;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class OperatorActivity extends BaseActivity<ActivityOperatorBinding, OperatorViewModel> implements OperatorNavigator,CustomRecycleAdapter.RecyleAdapterListener {


    @Inject
    OperatorViewModel mOperatorViewModel;
    private ActivityOperatorBinding  mActivityOperatorBinding;
    private Animation animation;
    @Inject
    ArrayList<HomeOptionModel> operatorArrayList;

    @Inject
    CustomRecycleAdapter customRecycleAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, OperatorActivity.class);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void getBundle(Bundle bundle) {
        mActivityOperatorBinding = getViewDataBinding();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_operator;
    }

    @Override
    public OperatorViewModel getViewModel() {
        return mOperatorViewModel;
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
        Intent intent = new Intent(OperatorActivity.this,NavigationDrawer.class);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityOperatorBinding = getViewDataBinding();
        mOperatorViewModel.setNavigator(this);
        setOperatorsAdapter();
    }

    private void setOperatorsAdapter() {

        customRecycleAdapter.setLayoutID(R.layout.operator_recyle_layout);
        customRecycleAdapter.setDataList(getOperatorList());
        customRecycleAdapter.setListener(this);
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_verysmall);
        mActivityOperatorBinding.recyclerView.setLayoutManager(getGridLayoutManager(2));
        mActivityOperatorBinding.recyclerView.setAdapter(customRecycleAdapter);
        mActivityOperatorBinding.recyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));
        mActivityOperatorBinding.recyclerView.setNestedScrollingEnabled(false);

    }

    private ArrayList<HomeOptionModel> getOperatorList() {
        HomeOptionModel homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Airtel Digital TV");
        homeOptionModel.setOptionIcon(R.drawable.adtv);
        operatorArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Dish TV");
        homeOptionModel.setOptionIcon(R.drawable.dtv);
        operatorArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Reliance Digital TV");
        homeOptionModel.setOptionIcon(R.drawable.rdtv);
        operatorArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Sun Direct");
        homeOptionModel.setOptionIcon(R.drawable.sdtv);
        operatorArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Tata Sky");
        homeOptionModel.setOptionIcon(R.drawable.ts);
        operatorArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Videocon d2h");
        homeOptionModel.setOptionIcon(R.drawable.vd2h);
        operatorArrayList.add(homeOptionModel);

        return operatorArrayList;
    }

    private GridLayoutManager getGridLayoutManager(int count){return new GridLayoutManager(this,count);}

    @Override
    public void onItemClick(CustomRecycleAdapter CRA, HomeOptionModel HOM) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("Operator",HOM.getOptionName());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
