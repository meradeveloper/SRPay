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

package com.srpay.in.di.builder;


import com.srpay.in.UI.DTH.DTHActivity;
import com.srpay.in.UI.DTH.DTHActivityModule;
import com.srpay.in.UI.Fragments.Home.HomeFragmentModule;
import com.srpay.in.UI.Fragments.Home.HomeFragmentProvider;
import com.srpay.in.UI.NetworkOperator.OperatorActivity;
import com.srpay.in.UI.NetworkOperator.OperatorActivityModule;
import com.srpay.in.UI.Recharge.RechargeActivity;
import com.srpay.in.UI.Recharge.RechargeActivityModule;
import com.srpay.in.UI.SideNavigation.NavigationActivityModule;
import com.srpay.in.UI.SideNavigation.NavigationDrawer;
import com.srpay.in.UI.SideNavigation.NavigationViewModel;
import com.srpay.in.UI.Splash.SplashActivity;
import com.srpay.in.UI.Splash.SplashActivityModule;
import com.srpay.in.UI.login.LoginActivity;
import com.srpay.in.UI.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public abstract class ActivityBuilder {

    /*@ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();*/

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = RechargeActivityModule.class)
    abstract RechargeActivity bindRechargeActivity();

    @ContributesAndroidInjector(modules = {NavigationActivityModule.class, HomeFragmentProvider.class})
    abstract NavigationDrawer bindNavigationActivity();

    @ContributesAndroidInjector(modules = DTHActivityModule.class)
    abstract DTHActivity bindDTHActivity();

    @ContributesAndroidInjector(modules = OperatorActivityModule.class)
    abstract OperatorActivity bindOperatorActivity();

}
