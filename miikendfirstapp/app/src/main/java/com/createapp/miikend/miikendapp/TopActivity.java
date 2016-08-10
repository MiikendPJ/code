package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class TopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //スタートボタンを取得
        Button start = (Button)findViewById(R.id.start);

        //Listener登録
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            //クリックされた場合の処理
            public void onClick(View view) {
                //Play画面起動
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(intent);
                TopActivity.this.finish();
            }
        });
    }

    //戻るキーを押した時の動作
    @Override
    public void onBackPressed() {
        //ここにやりたい事を書く
        // ダイアログの設定
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("確認");
        alertDialog.setMessage("アプリを終了しますか？");
        alertDialog.setPositiveButton("終了する", new DialogInterface.OnClickListener() {

            //終了するをクリックでActivity終了
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TopActivity.this.finish();
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
    /*//KEYCODE_BACKを無効化
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:

                    // ダイアログの設定
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("確認");
                    alertDialog.setMessage("アプリを終了しますか？");
                    alertDialog.setPositiveButton("終了する", new DialogInterface.OnClickListener() {

                        //終了するをクリックでActivity終了
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            TopActivity.this.finish();
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

                 // 親クラスのdispatchKeyEvent()を呼び出さないためにtrueを返す
                 return true;
            }
        }
        return super.dispatchKeyEvent(event);
        **/

}
