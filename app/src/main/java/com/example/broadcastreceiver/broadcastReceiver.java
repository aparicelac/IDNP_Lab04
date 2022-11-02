package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class broadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.BROADCAST_ACTION".equals(intent.getAction())) {
            String msg = intent.getStringExtra("msg");
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}


