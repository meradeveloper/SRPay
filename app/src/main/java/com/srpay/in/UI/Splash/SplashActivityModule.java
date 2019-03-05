package com.srpay.in.UI.Splash;


import com.srpay.in.data.DataManager;
import com.srpay.in.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Localadmin on 11/3/2018.
 */
@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){return new SplashViewModel(dataManager,schedulerProvider);};
}
