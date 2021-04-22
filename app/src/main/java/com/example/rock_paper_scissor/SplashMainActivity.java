package com.example.rock_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashMainActivity extends Activity {

    private final int DURATION_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_main);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashMainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURATION_SPLASH);
    }
}