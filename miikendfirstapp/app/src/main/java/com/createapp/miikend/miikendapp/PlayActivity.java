package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.createapp.miikend.miikendapp.base.AppBaseActivity;

public class PlayActivity extends AppBaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //戻るボタン取得とListener登録
        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(this);

        //resetボタン取得
        //TODO:View自体のパラメータを変更する事が無いなら、キャストして参照せずにこれでもOK
        findViewById(R.id.reset).setOnClickListener(this);

        //stopボタン取得とListener登録。stubとしてResult画面へ遷移させるボタンにしてます
        ImageButton stop = (ImageButton)findViewById(R.id.stop);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                createAlertDialog("確認", "ゲームを終了してTOP画面に戻りますか？", "戻る", "キャンセル", commonActivityFinishDialogListener()).show();
                break;
            case R.id.stop:
                //Result画面へ遷移
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);

                PlayActivity.this.finish();
                break;
            case R.id.reset:
                break;
        }
    }
}
