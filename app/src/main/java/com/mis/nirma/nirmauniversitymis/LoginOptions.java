package com.mis.nirma.nirmauniversitymis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("onReceive","Logout in progress");
                finish();
            }
        }, intentFilter);


        Button StudentLogin;
        StudentLogin  = (Button)findViewById(R.id.button);

        Button EmployeeLogin;
        EmployeeLogin  = (Button)findViewById(R.id.button2);

        Button OtherUsersLogin;
        OtherUsersLogin  = (Button)findViewById(R.id.button3);

        Button AdminLogin;
        AdminLogin  = (Button)findViewById(R.id.button4);


        final Intent i = new Intent(getApplicationContext(),StudentLoginActivity.class);
        StudentLogin.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        i.putExtra("id","student");
                        startActivity(i);
                    }
                });
        EmployeeLogin.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        i.putExtra("id","employee");
                        startActivity(i);
                    }
                });
        OtherUsersLogin.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
//                        i.putExtra("id","parent");
                        //Intent i=new Intent(LoginOptions.this,Register_par_stud.class);
                        i.putExtra("id","parent");
                        startActivity(i);

                        //startActivity(i);
                    }
                });
        AdminLogin.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        i.putExtra("id","admin");
                        startActivity(i);
                    }
                });

    }

}
