package com.mis.nirma.nirmauniversitymis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import static android.graphics.Color.TRANSPARENT;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class WelcomeScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_screen);

        ImageButton UniversityLogo;
        UniversityLogo  = (ImageButton)findViewById(R.id.nirmaUniversityLogo);
        UniversityLogo.setBackgroundColor(TRANSPARENT);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(WelcomeScreen.this, LoginOptions.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
