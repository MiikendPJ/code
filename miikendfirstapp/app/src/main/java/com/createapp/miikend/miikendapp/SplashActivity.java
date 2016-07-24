package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //2秒後にTopActivityに遷移
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), TopActivity.class);
                startActivity(intent);
                //SplashActivity終了
                SplashActivity.this.finish();
            }
        }, 2 * 1000);
    }
}

