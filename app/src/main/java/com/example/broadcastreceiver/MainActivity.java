package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtInternalMsg;
    private Button btn;
    broadcastReceiver receiver = new broadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtInternalMsg = findViewById(R.id.edtInternalMsg);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(sendInternalMessage);
        IntentFilter filter = new IntentFilter("com.example.BROADCAST_ACTION");
        registerReceiver(receiver, filter);
    }

    private View.OnClickListener sendInternalMessage = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent("com.example.BROADCAST_ACTION");
            intent.putExtra("msg", edtInternalMsg.getText().toString());
            sendBroadcast(intent);
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
