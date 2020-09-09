package com.mis.nirma.nirmauniversitymis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PasswordPrompt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_prompt);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("onReceive","Logout in progress");
                //At this point you should start the login activity and finish this one
                finish();
            }
        }, intentFilter);


        Button PasswordPromptSubmitButton;
        PasswordPromptSubmitButton  = (Button)findViewById(R.id.PasswordPromptSubmitButton);


        PasswordPromptSubmitButton.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),LoginOptions.class));
                    }
                });

    }
}
