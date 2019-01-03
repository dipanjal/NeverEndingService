package com.glitchstudios.dipanjal.neverendingservicetest;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.glitchstudios.dipanjal.neverendingservicetest.application.MyApplication;
import com.glitchstudios.dipanjal.neverendingservicetest.services.TestService;

public class MainActivity extends AppCompatActivity {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApplication = MyApplication.getInstance();
    }

    public void startTestService(View view){
        if(!isMyServiceRunning(TestService.class)){
//            startService(new Intent(this,TestService.class));
//            startForegroundService(new Intent(this,TestService.class));
            myApplication.startAService();
        }
    }

    public void stopTestService(View view){
//        stopService(new Intent(this,TestService.class));
        myApplication.stopRunningService();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                Toast.makeText(this, "Test Service Running", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        Toast.makeText(this, "Test Service Closed", Toast.LENGTH_SHORT).show();
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }
}
