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

package com.srpay.in.Base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.srpay.in.Adapters.CustomRecycleAdapter;
import com.srpay.in.R;
import com.srpay.in.UI.Fragments.Home.HomeFragment;
import com.srpay.in.UI.RecycleView.ItemOffsetDecoration;

import java.util.ArrayList;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by amitshekhar on 09/07/17.
 */

public abstract class BaseRecycleViewFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment implements CustomRecycleAdapter.RecyleAdapterListener {

    private BaseActivity mActivity;
    private View mRootView;
    private T mViewDataBinding;
    private V mViewModel;
    private CustomRecycleAdapter customRecycleAdapter;
    private int anim=0;
    private RecyclerView mRecyclerView;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();
    protected abstract int getAdapterLayoutID();
    protected abstract View getAdapterView(View view);
    protected abstract View setAdapterViewContent(CustomRecycleAdapter.CustomViewHolder CVH, int position);
    protected abstract int getRecycleViewID();
    protected abstract int getAnimationItems();
    protected abstract RecyclerView.LayoutManager getLayoutManager(Context context);
    protected abstract int setAdapterCount();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
        anim = getAnimationItems();
        mRecyclerView = view.findViewById(getRecycleViewID());
        setupRecyclerView();
        if(anim==0)
            runLayoutAnimation(mRecyclerView, anim);
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    private void setupRecyclerView() {
        /*customRecycleAdapter = new CustomRecycleAdapter();
        customRecycleAdapter.setLayoutID(getAdapterLayoutID());
        final Context context = mRecyclerView.getContext();
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_verysmall);
        mRecyclerView.setLayoutManager(getLayoutManager(context));
        mRecyclerView.setAdapter(customRecycleAdapter);
        mRecyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));*/
    }

    private void runLayoutAnimation(final RecyclerView recyclerView, final int item) {
        final Context context = recyclerView.getContext();

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, item);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    public void openActivityOnTokenExpire() {
        /*if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }*/
    }

    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
