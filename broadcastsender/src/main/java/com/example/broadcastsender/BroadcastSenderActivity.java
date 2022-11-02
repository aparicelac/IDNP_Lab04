package com.example.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastSenderActivity extends AppCompatActivity {
    private EditText edtMsg;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_sender);
        edtMsg = findViewById(R.id.edtMsg);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(sendMessage);
    }
    private View.OnClickListener sendMessage = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent("com.example.BROADCAST_ACTION");
            intent.putExtra("msg", edtMsg.getText().toString());
            sendBroadcast(intent);
        }
    };
}

