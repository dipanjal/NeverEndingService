package com.glitchstudios.dipanjal.neverendingservicetest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.glitchstudios.dipanjal.neverendingservicetest.services.TestService;

public class ServiceRestarterBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "ServiceRestarterBroadca";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "onReceive: action: "+action);
        Toast.makeText(context, "restarting service.....", Toast.LENGTH_SHORT).show();
        context.startService(new Intent(context,TestService.class));
    }
}
