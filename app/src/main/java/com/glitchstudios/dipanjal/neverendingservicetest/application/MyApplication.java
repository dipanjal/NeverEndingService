package com.glitchstudios.dipanjal.neverendingservicetest.application;

import android.app.Application;
import android.content.Intent;

import com.glitchstudios.dipanjal.neverendingservicetest.services.TestService;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    private static MyApplication mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance(){
        return mInstance;
    }

    public void startAService(){
        startService(new Intent(this,TestService.class));
    }

    public void stopRunningService(){
        stopService(new Intent(this,TestService.class));
    }
}
