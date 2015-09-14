package com.ashokslsk.twitterdigits;

import android.app.Application;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Ashu on 14/09/15.
 */
public class DemoApplication extends Application {
    private AuthCallback authCallback;

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("pfHN2Q7qtC5BRHxnoTYK7ZOGR", "CIcKLznbwVnuuHuPyLNSsjN8X4OtgoMtZwf20QgJeSby2VJep9");
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        authCallback = new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // Do something with the session
                Digits.authenticate(authCallback,"+919901356240");

            }

            @Override
            public void failure(DigitsException exception) {
                // Do something on failure
            }
        };
    }

    public AuthCallback getAuthCallback(){
        return authCallback;
    }

}