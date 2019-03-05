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

package com.srpay.in.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.srpay.in.BuildConfig;
import com.srpay.in.R;
import com.srpay.in.data.AppDataManager;
import com.srpay.in.data.DataManager;
import com.srpay.in.data.local.db.AppDatabase;
import com.srpay.in.data.local.db.AppDbHelper;
import com.srpay.in.data.local.db.DbHelper;
import com.srpay.in.data.local.prefs.AppPreferencesHelper;
import com.srpay.in.data.local.prefs.PreferencesHelper;
import com.srpay.in.data.remote.ApiHeader;
import com.srpay.in.data.remote.ApiHelper;
import com.srpay.in.data.remote.AppApiHelper;
import com.srpay.in.di.ApiInfo;
import com.srpay.in.di.DatabaseInfo;
import com.srpay.in.di.PreferenceInfo;
import com.srpay.in.utils.AppConstants;
import com.srpay.in.utils.GlideImageLoadingService;
import com.srpay.in.utils.PicassoImageLoadingService;
import com.srpay.in.utils.rx.AppSchedulerProvider;
import com.srpay.in.utils.rx.SchedulerProvider;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    PicassoImageLoadingService providePicassoImageLoadingService(Context context) {
        return new PicassoImageLoadingService(context);
    }

    @Provides
    @Singleton
    GlideImageLoadingService provideGlideImageLoadingService(Context context) {
        return new GlideImageLoadingService(context);
    }

    @Provides
    @Singleton
    OkHttpClient provideOKHTTPClient()
    {
        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId());
    }

    @Provides
    @Singleton
    ApiHeader.PublicApiHeader providePublicApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.PublicApiHeader(
                "application/x-www-form-urlencoded",
                "becbbce45f79c6f5109f848acd540567",
                "MC6dKW278tBef+AuqL/5rW2K3WgOegF0ZHLW/FriZQw=",
                "1516705204593",
                "no-cache"
                );
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
