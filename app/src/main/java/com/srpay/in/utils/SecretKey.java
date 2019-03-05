package com.srpay.in.utils;

import android.annotation.TargetApi;
import android.os.Build;

import android.util.Log;

import java.security.InvalidKeyException;
import android.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Localadmin on 12/5/2018.
 */

public class SecretKey {

    public static String getKey()
    {
        String key = "f74c50a1-f705-4634-9cda-30a477df91b7";
        String secret_key="",secret_key_timestamp="";
        Mac sha256_HMAC=null;

        // Encode it using base64
        String encodedKey = Base64.encodeToString(key.getBytes(),Base64.DEFAULT);

        Date date = new Date();
        secret_key_timestamp = Long.toString(date.getTime());

        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec signature = new SecretKeySpec(encodedKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(signature);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.e("Exception","SHAException "+e.toString());
        }

        // Encode it using base64 to get secret-key
        secret_key =  Base64.encodeToString(sha256_HMAC.doFinal(secret_key_timestamp.getBytes()),Base64.DEFAULT).trim();

        Log.e("secret_key_timestamp : ",secret_key_timestamp);
        Log.e("secret_key : ",secret_key);
        return secret_key;
    }
}
