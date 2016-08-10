package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //戻るボタン取得とListener登録
        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            //クリックされた場合の処理
            public void onClick(View view) {

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

            }
        });



        //resetボタン取得
        ImageButton reset = (ImageButton)findViewById(R.id.reset);





        //stopボタン取得とListener登録。stubとしてResult画面へ遷移させるボタンにしてます
        ImageButton stop = (ImageButton)findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            //クリックされた場合の処理
            public void onClick(View view) {
                //Result画面へ遷移
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);

                PlayActivity.this.finish();
            }
        });
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
