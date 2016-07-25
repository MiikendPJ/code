package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class ResultActivity extends Activity implements View.OnClickListener{

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
                //Play画面に遷移
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(intent);
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

    //KEYCODE_BACKを無効化
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:

                    // ダイアログ表示
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResultActivity.this);
                    alertDialog.setTitle("確認");
                    alertDialog.setMessage("スコアを破棄してTOP画面に戻ります");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        //終了するをクリックでActivityを終了してTop画面に戻る
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), TopActivity.class);
                            startActivity(intent);

                            ResultActivity.this.finish();
                        }
                    });
                    alertDialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {

                        //キャンセルをクリックでダイアログ終了（何も書いてないけど大丈夫かな・・・）
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.create().show();

                    // 親クラスのdispatchKeyEvent()を呼び出さないためにtrueを返す
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
