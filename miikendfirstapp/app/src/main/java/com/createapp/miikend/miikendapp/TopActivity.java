package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //スタートボタンにタップイベント取得を付与
        Button start = (Button)findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.start) {
            //ゲーム画面起動
            Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
            startActivity(intent);
        }
    }
}
