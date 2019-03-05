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

package com.srpay.in.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.srpay.in.data.local.db.DbHelper;
import com.srpay.in.data.local.prefs.PreferencesHelper;
import com.srpay.in.data.model.api.LoginRequest;
import com.srpay.in.data.model.api.LogoutResponse;
import com.srpay.in.data.model.db.Option;
import com.srpay.in.data.remote.ApiHeader;
import com.srpay.in.data.remote.ApiHelper;


import org.json.JSONArray;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Singleton
public class AppDataManager implements DataManager {


    private final ApiHelper mApiHelper;

    private final Context mContext;
    private String Blank = "";

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {
        return null; /*mDbHelper.isOptionEmpty()
                .concatMap(isEmpty -> {
                    if (isEmpty) {
                        Type type = new TypeToken<List<Option>>() {
                        }.getType();
                        List<Option> optionList = mGson.fromJson(CommonUtils.loadJSONFromAsset(mContext, AppConstants.SEED_DATABASE_OPTIONS), type);
                        return saveOptionList(optionList);
                    }
                    return Observable.just(false);
                });*/
    }

    @Override
    public void setUserAsLoggedOut() {
        Log.e("Logout","Logout");
        updateUserInfo(
                Blank,
                Blank,
                Blank,
                Blank,
                Blank,
                Blank);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        //mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        //mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String uid,
            String users_name,
            String phone_number,
            String email,
            String APPVER,
            String SID) {

        setUID(uid);
        setUserName(users_name);
        setPhoneNumber(phone_number);
        setEmail(email);
        setAppVersion(APPVER);
        setSID(SID);
    }


    @Override
    public void setUID(String userId) {
        mPreferencesHelper.setUID(userId);
    }

    @Override
    public void setEmail(String Email) {
        mPreferencesHelper.setEmail(Email);
    }

    @Override
    public void setUserName(String UserName) {
        mPreferencesHelper.setUserName(UserName);
    }

    @Override
    public void setSID(String SID) {
        mPreferencesHelper.setSID(SID);
    }

    @Override
    public void setAppVersion(String AppVersion) {
        mPreferencesHelper.setAppVersion(AppVersion);
    }

    @Override
    public void setPhoneNumber(String PhoneNumber) {
        mPreferencesHelper.setPhoneNumber(PhoneNumber);
    }


    @Override
    public String getEmail() {
        return mPreferencesHelper.getEmail();
    }

    @Override
    public String getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public String getSID() {
        return mPreferencesHelper.getSID();
    }

    @Override
    public String getAppVersion() {
        return mPreferencesHelper.getAppVersion();
    }

    @Override
    public String getPhoneNumber() {
        return mPreferencesHelper.getPhoneNumber();
    }

    @Override
    public Observable<List<Option>> getOptionsForQuestionId(Long questionId) {
        return null;
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return null;
    }

    @Override
    public Observable<JSONArray> doLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doLoginApiCall(request);
    }

    @Override
    public ApiHeader getApiHeader() {
        return null;
    }
}
