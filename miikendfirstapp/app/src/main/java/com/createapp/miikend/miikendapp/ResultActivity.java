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

public class ResultActivity extends AppBaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //replayボタンを取得とListener登録
        ImageButton replay = (ImageButton) findViewById (R.id.replay);
        replay.setOnClickListener(this);

        //twitterボタンを取得とListener登録
        ImageButton twitter = (ImageButton) findViewById (R.id.twitter);
        twitter.setOnClickListener(this);

        //facebookボタンの取得とListener登録
        ImageButton faceboook = (ImageButton) findViewById (R.id.facebook);
        faceboook.setOnClickListener(this);

    }

    //クリックイベントの振り分け
    public void onClick(View view) {

        //switch文で複数ボタンのクリックを制御
        switch (view.getId()) {

            //replayボタン押下時
            case R.id.replay:
                DialogInterface.OnClickListener replayDialogListener = new DialogInterface.OnClickListener() {

                    //キャンセルをクリックでダイアログ終了（何も書いてないけど大丈夫かな・・・）
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                createAlertDialog("確認", "スコアを破棄して再度プレイしますか？", "再プレイ", "キャンセル", replayDialogListener).show();

                break;

            //twitterボタン押下時
            case R.id.twitter:
                //twitter投稿画面へ遷移


                break;

            //facebookボタン押下時
            case R.id.facebook:
                //facebook投稿画面へ遷移


                break;

        }
    }

}
