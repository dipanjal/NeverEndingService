package com.glitchstudios.dipanjal.neverendingservicetest.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.glitchstudios.dipanjal.neverendingservicetest.actions.MyIntentActions;
import com.glitchstudios.dipanjal.neverendingservicetest.receiver.ServiceRestarterBroadcastReceiver;
import com.glitchstudios.dipanjal.neverendingservicetest.utlis.DateUtilHelper;

public class TestService extends Service {

    private static final String TAG = "TestService";
    DateUtilHelper dateUtilHelper;
    Handler handler;
    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler=new Handler();
        dateUtilHelper = DateUtilHelper.getInstance();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        handler.post(runnable);
        return START_STICKY;
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                String currentDate = dateUtilHelper.getCurrentdateString(DateUtilHelper.CURRENT_TIME_12HOURS_FORMAT);
                Toast.makeText(TestService.this, "Service Running "+currentDate, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "run: service running...."+currentDate);
                handler.postDelayed(runnable,2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: survice destroyed");
        handler.removeCallbacks(runnable); //managing handler to stop the runnable
        Intent broadcastIntent = new Intent(this,ServiceRestarterBroadcastReceiver.class);
        broadcastIntent.setAction(MyIntentActions.RESTART_MY_SERVICE);
//        Intent broadcastIntent = new Intent(MyIntentActions.RESTART_MY_SERVICE);
        sendBroadcast(broadcastIntent);
    }

}
