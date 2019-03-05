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

package com.srpay.in.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.srpay.in.di.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by amitshekhar on 07/07/17.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_UID = "PREF_KEY_UID";

    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";

    private static final String PREF_KEY_APP_VERSION = "PREF_KEY_APP_VERSION";

    private static final String PREF_KEY_USERNAME = "PREF_KEY_USERNAME";

    private static final String PREF_KEY_SID = "PREF_KEY_SID";

    private static final String PREF_KEY_PHONE_NUMBER = "PREF_KEY_PHONE_NUMBER";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void setUID(String userId) {
        mPrefs.edit().putString(PREF_KEY_UID, userId).apply();
    }

    @Override
    public void setEmail(String Email) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, Email).apply();
    }

    @Override
    public void setUserName(String UserName) {
        mPrefs.edit().putString(PREF_KEY_USERNAME, UserName).apply();
    }

    @Override
    public void setSID(String SID) {
        mPrefs.edit().putString(PREF_KEY_SID, SID).apply();
    }

    @Override
    public void setAppVersion(String AppVersion) {
        mPrefs.edit().putString(PREF_KEY_APP_VERSION, AppVersion).apply();
    }

    @Override
    public void setPhoneNumber(String PhoneNumber) {
        mPrefs.edit().putString(PREF_KEY_PHONE_NUMBER, PhoneNumber).apply();
    }

    @Override
    public String getEmail() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public String getCurrentUserId() {
        return mPrefs.getString(PREF_KEY_UID, null);
    }

    @Override
    public String getUserName() {
        return mPrefs.getString(PREF_KEY_USERNAME, null);
    }

    @Override
    public String getSID() {
        return mPrefs.getString(PREF_KEY_SID, null);
    }

    @Override
    public String getAppVersion() {
        return mPrefs.getString(PREF_KEY_APP_VERSION, null);
    }

    @Override
    public String getPhoneNumber() {
        return mPrefs.getString(PREF_KEY_PHONE_NUMBER, null);
    }
}
