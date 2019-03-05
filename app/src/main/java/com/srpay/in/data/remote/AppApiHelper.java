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

package com.srpay.in.data.remote;


import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srpay.in.data.local.prefs.PreferencesHelper;
import com.srpay.in.data.model.api.LoginRequest;
import com.srpay.in.data.model.api.LoginResponse;
import com.srpay.in.data.model.api.LogoutResponse;

import org.json.JSONArray;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.OkHttpClient;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;
    @Inject
    OkHttpClient okHttpClient;
    @Inject
    PreferencesHelper mPref;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }



    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }


    @Override
    public Observable<JSONArray> doLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_OTP_REQUEST)
               // .addHeaders(mApiHeader.getPublicApiHeader())
                .addHeaders("developer_key","becbbce45f79c6f5109f848acd540567")
                .addHeaders("secret-key","MC6dKW278tBef+AuqL/5rW2K3WgOegF0ZHLW/FriZQw=")
                .addHeaders("secret-key-timestamp","1516705204593")
                .addHeaders("Content-Type","application/x-www-form-urlencoded")
                .addHeaders("cache-control","no-cache")
                .setOkHttpClient(okHttpClient)
                .addBodyParameter("initiator_id","9962981729")
                .addBodyParameter("mobile","8646546454")
                .build()
                .getJSONArrayObservable();
    }




    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }




}
