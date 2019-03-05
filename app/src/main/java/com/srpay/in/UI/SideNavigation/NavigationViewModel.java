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

import android.text.TextUtils;

import com.srpay.in.Base.BaseViewModel;
import com.srpay.in.UI.login.LoginNavigator;
import com.srpay.in.data.DataManager;
import com.srpay.in.utils.CommonUtils;
import com.srpay.in.utils.rx.SchedulerProvider;


/**
 * Created by amitshekhar on 08/07/17.
 */

public class NavigationViewModel extends BaseViewModel<NavigationNavigator> {

    public NavigationViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password

        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        /*setIsLoading(true);
        Log.e("login","login");
        getCompositeDisposable().add(getDataManager()
                .doLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .doAfterNext(response->{TypeToken<List<LoginResponse>> token = new TypeToken<List<LoginResponse>>(){};
                            List<LoginResponse> User = new Gson().fromJson(String.valueOf(response), token.getType());
                            getDataManager().updateUserInfo(
                                    User.get(0).getUid(),
                                    User.get(0).getUsers_name(),
                                    User.get(0).getPhone_number(),
                                    User.get(0).getEmail(),
                                    User.get(0).getAPPVER(),
                                    User.get(0).getSID()
                            );
                }
                )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    Log.e("login","UID : "+response.get(0).toString()+" Username : "+response.get(0).toString());
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));*/

        //getNavigator().openMainActivity();
    }


    public void onServerLoginClick() {
        getNavigator().login();

    }
}
