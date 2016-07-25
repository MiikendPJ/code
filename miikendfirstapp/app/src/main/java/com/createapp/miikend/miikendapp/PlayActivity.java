package com.createapp.miikend.miikendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //戻るボタン取得とListener登録

    }

    //KEYCODE_BACKを無効化
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:

                    // ダイアログ表示
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(PlayActivity.this);
                    alertDialog.setTitle("確認");
                    alertDialog.setMessage("ゲームを終了しますか？");
                    alertDialog.setPositiveButton("終了する", new DialogInterface.OnClickListener() {

                        //終了するをクリックでActivity終了。Top画面に戻る
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            PlayActivity.this.finish();
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
