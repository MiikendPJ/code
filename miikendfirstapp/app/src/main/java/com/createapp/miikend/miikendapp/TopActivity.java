package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.createapp.miikend.miikendapp.base.AppBaseActivity;

public class TopActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //スタートボタンを取得
        Button start = (Button)findViewById(R.id.start);

        View.OnClickListener listener = createClickListener();
        //Listener登録
        start.setOnClickListener(listener);
    }

    /**
     * この画面でのクリック処理
     * @return
     */
    private View.OnClickListener createClickListener(){
        return new View.OnClickListener(){
            //クリックされた場合の処理
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.start:
                        //Play画面起動
                        Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
    }
}
