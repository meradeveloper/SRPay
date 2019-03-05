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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.srpay.in.di.ApiInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    private PublicApiHeader mPublicApiHeader;

    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader, ProtectedApiHeader protectedApiHeader) {
        mPublicApiHeader = publicApiHeader;
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return mPublicApiHeader;
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("access_token")
        private String mAccessToken;

        @Expose
        @SerializedName("api_key")
        private String mApiKey;

        @Expose
        @SerializedName("user_id")
        private String mUserId;

        public ProtectedApiHeader(String mApiKey, String mUserId) {
            this.mApiKey = mApiKey;
            this.mUserId = mUserId;
        }

        public String getAccessToken() {
            return mAccessToken;
        }

        public void setAccessToken(String accessToken) {
            mAccessToken = accessToken;
        }

        public String getApiKey() {
            return mApiKey;
        }

        public void setApiKey(String apiKey) {
            mApiKey = apiKey;
        }

        public String getUserId() {
            return mUserId;
        }

        public void setUserId(String mUserId) {
            this.mUserId = mUserId;
        }
    }

    public static final class PublicApiHeader {

        @Expose
        @SerializedName("content-type")
        private String mContentType;

        @Expose
        @SerializedName("developer_key")
        private String mDeveloperKey;

        @Expose
        @SerializedName("secret-key")
        private String mSecretKey;

        @Expose
        @SerializedName("secret-key-timestamp")
        private String mSecretKeyTimestamp;

        @Expose
        @SerializedName("cache-control")
        private String mCacheControl;


        @Inject
        public PublicApiHeader(
                String content_type,
                String developer_key,
                String secret_key,
                String secret_key_timestamp,
                String cache_control
        ) {
            mContentType = content_type;
            mDeveloperKey = developer_key;
            mSecretKey = secret_key;
            mSecretKeyTimestamp = secret_key_timestamp;
            mCacheControl = cache_control;
        }

        public String getmContentType() {
            return mContentType;
        }

        public String getmDeveloperKey() {return mDeveloperKey;}

        public String getmSecretKey() {return mSecretKey;}

        public String getmSecretKeyTimestamp() {return mSecretKeyTimestamp;}

        public String getmCacheControl() {return mCacheControl;}
    }
}
