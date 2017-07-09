package com.example.bioauthentication;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity  {

    // Constant Value for Splash Screen time visibility
    private static int SPLASH_SCREEN_TIME = 700;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create object of Handler class and call method postDelayed to make
        // Splash Screen visible for SPLASH_SCREEN_TIME
        new Handler().postDelayed(new Runnable() {

            public void run() {
                // This is method will be executed when SPLASH_SCREEN_TIME is
                // over, Now you can call your Home Screen
                Intent iHomeScreen = new Intent(getApplicationContext(),
                        Home1.class);
                startActivity(iHomeScreen);

                // Finish Current Splash Screen, as it should be visible only
                // once when application start
                finish();
            }

        }, SPLASH_SCREEN_TIME);
    }
}