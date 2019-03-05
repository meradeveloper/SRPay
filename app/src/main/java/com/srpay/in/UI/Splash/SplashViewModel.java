package com.srpay.in.UI.Splash;

import android.util.Log;

import com.srpay.in.Base.BaseViewModel;
import com.srpay.in.data.DataManager;
import com.srpay.in.utils.rx.SchedulerProvider;

/**
 * Created by Localadmin on 11/3/2018.
 */

public class SplashViewModel extends BaseViewModel<SplashViewModel.SplashNavigator> {


    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public Boolean isAuthenticated()
    {
        //Log.e("UserDetail","UserId : "+getDataManager().getCurrentUserId());
        if(getDataManager().getCurrentUserId()!=null && !getDataManager().getCurrentUserId().isEmpty())
            return true;
        else
            return false;
    }

    public interface SplashNavigator{
        void onNavigate();
    }
}
