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

package com.srpay.in.UI.SideNavigation;


import com.srpay.in.UI.login.LoginViewModel;
import com.srpay.in.data.DataManager;
import com.srpay.in.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigationActivityModule {

    @Provides
    NavigationViewModel provideLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new NavigationViewModel(dataManager, schedulerProvider);
    }
}
