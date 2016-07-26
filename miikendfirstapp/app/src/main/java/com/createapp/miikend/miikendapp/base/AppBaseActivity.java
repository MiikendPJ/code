package com.createapp.miikend.miikendapp.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class AppBaseActivity extends Activity {

    @Override
    public void onBackPressed() {
        createAlertDialog("確認", "ゲームを終了してTOP画面に戻りますか？", "戻る", "キャンセル", commonActivityFinishDialogListener()).show();
    }

    /**
     * 今後を見据えればDialogFragmentで実装するのがいい
     * @param title
     * @param message
     * @param positiveBtnMes
     * @param negativeBtnMes
     * @param listener
     * @return
     */
    protected AlertDialog createAlertDialog(String title, String message, String positiveBtnMes, String negativeBtnMes, DialogInterface.OnClickListener listener){
        // ダイアログの設定
        //TODO:ダイアログはほぼ定型的な処理なので、ダイアログバリエーションを考えて生成処理を書いていけばいいです
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(positiveBtnMes, listener);
        alertDialog.setNegativeButton(negativeBtnMes, listener);
        return alertDialog.create();
    }

    /**
     * アクティビティを終了させるダイアログインターフェース
     * @return
     */
    protected DialogInterface.OnClickListener commonActivityFinishDialogListener(){
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                    case DialogInterface.BUTTON_NEUTRAL:
                        break;
                }
            }
        };
    }
}
