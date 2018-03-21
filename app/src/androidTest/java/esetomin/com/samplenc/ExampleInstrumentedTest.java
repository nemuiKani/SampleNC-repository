package esetomin.com.samplenc;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import esetomin.com.samplenc.activity.TopActivity;
import esetomin.com.samplenc.common.Const;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<TopActivity> {
    // Activity
    private TopActivity mActivity;
    // 順位
    private Spinner rankingSpinner;
    // 名前
    private TextView nameEdit;
    // コメント
    private TextView commentEdit;
    // 登録ボタン
    private Button registerButton;

    public ExampleInstrumentedTest() {
        super(TopActivity.class);
    }

    @Before
    public void setUpEditFragment() throws Exception {
        super.setUp();
        // 参考：http://starzero.hatenablog.com/entry/2013/01/23/150352

        // アクティビティを取得
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();

        // ActivityからFragmentを取得
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        // FragmentのViewを取得
        View v = fragment.getView();

        // 順位
        rankingSpinner = v.findViewById(R.id.fragment_edit_ranking_spinner);
        // 名前
        nameEdit = v.findViewById(R.id.fragment_edit_name_edit);
        // コメント
        commentEdit = v.findViewById(R.id.fragment_edit_comment_edit);
        // 登録ボタン
        registerButton = v.findViewById(R.id.fragment_edit_register_button);
    }

    @Test
    public void testEditFragmentIni() throws Exception {

        // 参考：http://language-and-engineering.hatenablog.jp/entry/20130121/UnitTestOfAndroidAppOnEclipse
        // UIスレッドで画面操作
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // １．順位に1～100が設定されていること
                SpinnerAdapter sp = rankingSpinner.getAdapter();
                for (int i = 0; i < 100; i++) {
                    assertEquals(i + 1, Integer.parseInt(sp.getItem(i).toString()));
                }
                // ２．名前に空白が設定されていること
                assertEquals("", nameEdit.getText().toString());
                // ３．コメントに空白が設定されていること
                assertEquals("", commentEdit.getText().toString());
            }
        });

        // UIスレッド待機
        getInstrumentation().waitForIdleSync();
    }

    @Test
    public void testEditFragmentRegister1() throws Exception {
        // コメント、名前を入力した場合のテスト

        // UIスレッドで画面操作
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 順位に50位を設定
                int rank = 49;
                // 名前に"テスト"を設定
                String name = "テスト";
                // コメントに秒＋ミリ秒を設定
                DateFormat format = new SimpleDateFormat("ss.SSS");
                String comment = format.format(new Date());

                // 各項目に設定
                rankingSpinner.setSelection(rank);
                nameEdit.setText(name);
                commentEdit.setText(comment);

                // １．順位に50が設定されていること
                assertEquals("50", rankingSpinner.getSelectedItem().toString());
                // ２．名前が設定されていること
                assertEquals(name, nameEdit.getText().toString());
                // ３．コメントが設定されていること
                assertEquals(comment, commentEdit.getText().toString());

                // 登録ボタンを押下
                registerButton.performClick();

                // ４．ランキングに当該データが存在することをチェック
                try {
                    assertEquals(true, isExistRanking(rank + 1, name, comment));
                } catch (Exception e) {
                    // assertで不一致にさせる
                    assertEquals(true, false);
                }
            }
        });

        // UIスレッド待機
        getInstrumentation().waitForIdleSync();
    }

    @Test
    public void testEditFragmentRegister2() throws Exception {
        // コメント、名前を入力しない場合のテスト

        // UIスレッドで画面操作
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 順位に47位を設定
                int rank = 46;
                // 名前に""を設定
                String name = "";
                // コメントに""を設定
                String comment = "";
                rankingSpinner.setSelection(rank);
                nameEdit.setText(name);
                commentEdit.setText(comment);

                // 登録ボタンを押下
                registerButton.performClick();

                // ランキングに当該データが存在することをチェック
                try {
                    assertEquals(true, isExistRanking(rank + 1, "名無しの権兵衛", "ノーコメント"));
                } catch (Exception e) {
                    // assertで不一致にさせる
                    assertEquals(true, false);
                }
            }
        });

        // UIスレッド待機
        getInstrumentation().waitForIdleSync();
    }

    // ランキングに当該データが存在することをチェック
    private boolean isExistRanking(int rank, String name, String comment) throws Exception {
        // ランキングを取得
        List<Map<String, String>> rankingList = new ArrayList<>();
        // 初期処理
        NCMB.initialize(getActivity().getApplicationContext(), Const.APP_KEY, Const.CLIENT_KEY);
        // クエリを作成
        NCMBQuery<NCMBObject> query = new NCMBQuery<>(Const.APP_NAME);

        //検索件数を100件に設定
        query.setLimit(100);
        try {
            // データストアでの検索を行う
            List<NCMBObject> objects = query.find();
            for (NCMBObject obj : objects) {
                Map<String, String> map = new HashMap<>();
                map.put(Const.NCMB_PARAM_NAME, obj.getString(Const.NCMB_PARAM_NAME));
                map.put(Const.NCMB_PARAM_COMMENT, obj.getString(Const.NCMB_PARAM_COMMENT));
                map.put(Const.NCMB_PARAM_RANK, obj.getString(Const.NCMB_PARAM_RANK));
                rankingList.add(map);
            }
        } catch (NCMBException e) {
            throw new Exception();
        }

        // 存在チェック
        boolean isExit = false;
        for (Map<String, String> map : rankingList) {
            // 名前、コメント、ランクの全てが一致する場合
            if (name.equals(map.get(Const.NCMB_PARAM_NAME)) &&
                    comment.equals(map.get(Const.NCMB_PARAM_COMMENT)) &&
                    String.valueOf(rank).equals(map.get(Const.NCMB_PARAM_RANK))) {
                isExit = true;
                break;
            }
        }
        return isExit;
    }

}
