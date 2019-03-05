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

package com.srpay.in.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amitshekhar on 07/07/17.
 */

public final class LoginResponse {

    @Expose
    @SerializedName("uid")
    private String uid;

    @Expose
    @SerializedName("users_name")
    private String users_name;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("full_name")
    private String full_name;

    @Expose
    @SerializedName("first_name")
    private String first_name;

    @Expose
    @SerializedName("last_name")
    private String last_name;

    @Expose
    @SerializedName("phone_number")
    private String phone_number;

    @Expose
    @SerializedName("parent_id")
    private String parent_id;

    @Expose
    @SerializedName("lang")
    private String lang;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("htmleditormode")
    private String htmleditormode;

    @Expose
    @SerializedName("templateeditormode")
    private String templateeditormode;

    @Expose
    @SerializedName("questionselectormode")
    private String questionselectormode;

    @Expose
    @SerializedName("one_time_pw")
    private String one_time_pw;

    @Expose
    @SerializedName("dateformat")
    private String dateformat;

    @Expose
    @SerializedName("created")
    private String created;

    @Expose
    @SerializedName("modified")
    private String modified;

    @Expose
    @SerializedName("SurveyNotoficationInterval")
    private String SurveyNotoficationInterval;

    @Expose
    @SerializedName("APPVER")
    private String APPVER;

    @Expose
    @SerializedName("UserState")
    private String UserState;

    @Expose
    @SerializedName("SID")
    private String SID;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHtmleditormode() {
        return htmleditormode;
    }

    public void setHtmleditormode(String htmleditormode) {
        this.htmleditormode = htmleditormode;
    }

    public String getTemplateeditormode() {
        return templateeditormode;
    }

    public void setTemplateeditormode(String templateeditormode) {
        this.templateeditormode = templateeditormode;
    }

    public String getQuestionselectormode() {
        return questionselectormode;
    }

    public void setQuestionselectormode(String questionselectormode) {
        this.questionselectormode = questionselectormode;
    }

    public String getOne_time_pw() {
        return one_time_pw;
    }

    public void setOne_time_pw(String one_time_pw) {
        this.one_time_pw = one_time_pw;
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSurveyNotoficationInterval() {
        return SurveyNotoficationInterval;
    }

    public void setSurveyNotoficationInterval(String surveyNotoficationInterval) {
        SurveyNotoficationInterval = surveyNotoficationInterval;
    }

    public String getAPPVER() {
        return APPVER;
    }

    public void setAPPVER(String APPVER) {
        this.APPVER = APPVER;
    }

    public String getUserState() {
        return UserState;
    }

    public void setUserState(String userState) {
        UserState = userState;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}
