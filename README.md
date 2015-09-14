# Twitter-Fabric-Digits-integration
**Twitter Fabric Digits integration**

Using twitter fabric sdk to implement OTP via sms using twitter digits

![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen1.png)

This program is developed using twitter fabric sdk in android studio.

Make sure for the following configurations in your program to get started.


**Gradle dependency**
```sh

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:23.0.1'
    compile('com.digits.sdk.android:digits:1.8.0@aar') {
        transitive = true;
    }
}


```

**Manifest file and the permissions**
```sh

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="yourpackage" >

    <application
        android:name=".DemoApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <meta-data
            android:name="io.fabric.ApiKey"
            android:value="your value" />
    </application>

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    <uses-permission android:name="android.permission.RECEIVE_SMS"/>
</manifest>


```

**Twitter DigitsAuthButton **
```sh
 <com.digits.sdk.android.DigitsAuthButton
        android:id="@+id/auth_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```


**Write your Application class** 
```sh

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
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("your consumer key", "twitter secret key");
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

```

**In MainActivity Program**
```sh
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        setContentView(R.layout.activity_main);

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(((DemoApplication) getApplication()).getAuthCallback());

    }
```


**You can use place details api to continue further**

* [Fabric documentation] (https://docs.fabric.io/android/digits/digits.html)

![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen2.png)
![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen3.png)
![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen4.png)
![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen5.png)
![Screen](https://github.com/ashokslsk/Twitter-Fabric-Digits-integration/blob/master/screen/screen6.png)



Finally your done now.

- Execute the code with your api key and you are done simple as it is 

* [For more codes, funs and for queries be in touch with @ashokslsk ](https://github.com/ashokslsk)
