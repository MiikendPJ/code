package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayActivity extends Activity implements View.OnClickListener{

    //スコアカウント用の変数宣言
    int countMessage = 0;

    //スコアカウント毎にテキスト表示するメソッドを作成
    private void updateCountView() {
        TextView count = (TextView) findViewById(R.id.count);
        count.setText(String.valueOf(countMessage));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //戻るボタン取得とListener登録
        findViewById(R.id.back).setOnClickListener(this);

        //resetボタン取得
        findViewById(R.id.reset).setOnClickListener(this);

        //stopボタン取得とListener登録。stubとしてResult画面へ遷移させるボタンにしてます
        findViewById(R.id.stop).setOnClickListener(this);
    }

    //クリックイベントの振り分け
    public void onClick(View view) {

        //switch文で複数ボタンのクリックを制御
        switch (view.getId()) {

            case R.id.back :

                // ダイアログの設定
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PlayActivity.this);
                alertDialog.setTitle("確認");
                alertDialog.setMessage("ゲームを終了してTOP画面に戻りますか？");
                alertDialog.setPositiveButton("戻る", new DialogInterface.OnClickListener() {

                    //終了するをクリックでActivity終了。Top画面に戻る
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), TopActivity.class);
                        startActivity(intent);
                        PlayActivity.this.finish();
                    }
                });
                alertDialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {

                    //キャンセルをクリックでダイアログ終了（何も書いてないけど大丈夫かな・・・）
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //ダイアログの作成と表示
                alertDialog.create().show();

                break;

            case R.id.reset:


                break;

            case R.id.stop:

                //Result画面へ遷移
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);

                PlayActivity.this.finish();

                break;


        }
    }




    //画面タッチのイベント
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            //タッチされた場合
            case MotionEvent.ACTION_DOWN:

                //スコアを１プラス
                countMessage++;
                //追加したメソッドでテキスト表示
                updateCountView();


                break;

            case MotionEvent.ACTION_UP:

                break;
        }








        return super.onTouchEvent(event);
    }








    @Override
    public void onBackPressed() {
        //ここにやりたい事を書く
                    // ダイアログの設定
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("確認");
                    alertDialog.setMessage("ゲームを終了してTOP画面に戻りますか？");
                    alertDialog.setPositiveButton("戻る", new DialogInterface.OnClickListener() {

                        //終了するをクリックでActivity終了。Top画面に戻る
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), TopActivity.class);
                            startActivity(intent);
                            PlayActivity.this.finish();
                        }
                    });
                    alertDialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {

                        //キャンセルをクリックでダイアログ終了（何も書いてないけど大丈夫かな・・・）
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    //ダイアログの作成と表示
                    alertDialog.create().show();

    }
}
