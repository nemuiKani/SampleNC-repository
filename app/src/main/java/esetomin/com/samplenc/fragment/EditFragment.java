package esetomin.com.samplenc.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import esetomin.com.samplenc.R;
import esetomin.com.samplenc.common.Const;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

/**
 * 入力画面のフラグメント。
 *
 * @author nemuiKani
 * @version 1.0
 */
public class EditFragment extends Fragment {

    private static final String NO_NAME = "名無しの権兵衛";
    private static final String NO_COMMENT = "ノーコメント";
    private static final String REGISTER_MESSAGE = "登録しました。";

    /**
     * onCreateViewイベント。
     *
     * @param inflater           LayoutInflater
     * @param container          ViewGroup
     * @param savedInstanceState savedInstanceState
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_edit, container, false);

        // 順位
        final Spinner rankingSpinner = view.findViewById(R.id.fragment_edit_ranking_spinner);
        // 順位の選択肢を設定
        rankingSpinner.setAdapter(createSpinnerItems());

        // 名前
        final TextView nameEdit = view.findViewById(R.id.fragment_edit_name_edit);
        // コメント
        final TextView commentEdit = view.findViewById(R.id.fragment_edit_comment_edit);

        // 登録ボタン
        final Button registerButton = view.findViewById(R.id.fragment_edit_register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンの非活性化
                registerButton.setEnabled(false);
                // 非活性デザインへ変更
                changeButtonDesign(registerButton, R.drawable.button_design_after_touch);

                // 値取得
                // 名前
                String rankingName = nameEdit.getText().toString();
                // コメント
                String rankingComment = commentEdit.getText().toString();

                // 空文字の置換
                // 名前が空文字の場合
                if (TextUtils.isEmpty(rankingName.trim())) {
                    rankingName = NO_NAME;
                }
                // コメントが空文字の場合
                if (TextUtils.isEmpty(rankingComment.trim())) {
                    rankingComment = NO_COMMENT;
                }

                // ランキングへ登録
                registerRanking(rankingName, rankingComment,
                        Integer.parseInt(rankingSpinner.getSelectedItem().toString()));

                // 名前、コメントの初期化
                nameEdit.setText("");
                commentEdit.setText("");

                // ボタンの活性化
                registerButton.setEnabled(true);
                // デザインを元に戻す
                changeButtonDesign(registerButton, R.drawable.button_design);
            }
        });

        return view;
    }

    private ArrayAdapter<String> createSpinnerItems() {
        // 1～100までの整数を設定する
        String spinnerItems[] = new String[100];
        int i = 0;
        while (i < 100) {
            spinnerItems[i] = String.valueOf(i + 1);
            i++;
        }
        return new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, spinnerItems);
    }

    private void changeButtonDesign(Button button, int drawableItemId) {
        Resources res = getResources();
        Drawable drawableDisable = res.getDrawable(drawableItemId);
        button.setBackground(drawableDisable);
    }

    private void registerRanking(String rankingName, String rankingComment, int rank) {
        // 初期処理
        NCMB.initialize(getContext(), Const.APP_KEY, Const.CLIENT_KEY);
        // クラスのNCMBObjectを作成
        NCMBObject obj = new NCMBObject(Const.APP_NAME);
        // オブジェクトの値を設定
        obj.put(Const.NCMB_PARAM_RANK, rank);
        obj.put(Const.NCMB_PARAM_NAME, rankingName);
        obj.put(Const.NCMB_PARAM_COMMENT, rankingComment);
        // データストアへの登録
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    // 保存に失敗した場合の処理
                    // トースタにエラー内容を表示
                    Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    // 保存に成功した場合の処理
                    Toast.makeText(getActivity().getApplicationContext(), REGISTER_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}