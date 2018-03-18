package esetomin.com.samplenc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import esetomin.com.samplenc.R;
import esetomin.com.samplenc.common.Const;

/**
 * ランキング画面のフラグメント。
 *
 * @author Taro
 * @version 1.0
 */
public class RankingFragment extends Fragment {

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
        final View view = inflater.inflate(R.layout.fragment_ranking, container, false);

        // ランキングを取得
        List<Map<String, String>> rankingList = new ArrayList<>();
        // 初期処理
        NCMB.initialize(getContext(), Const.APP_KEY, Const.CLIENT_KEY);
        // クエリを作成
        NCMBQuery<NCMBObject> query = new NCMBQuery<>(Const.APP_NAME);
        // ランクの昇順の昇順、登録日時の降順でデータを取得
        query.addOrderByAscending(Const.NCMB_PARAM_RANK);
        query.addOrderByDescending(Const.NCMB_PARAM_CREATE_DATE);
        //検索件数を10件に設定
        query.setLimit(100);
        try {
            //データストアでの検索を行う
            List<NCMBObject> objects = query.find();
            for (NCMBObject obj :objects) {
                Map<String,String> map = new HashMap<>();
                // simple_list_item_2を使いたいので編集
                StringBuilder sb = new StringBuilder();
                sb.append(obj.getString(Const.NCMB_PARAM_RANK));
                sb.append("位　");
                sb.append(obj.getString(Const.NCMB_PARAM_NAME));

                map.put(Const.NCMB_PARAM_RANK, sb.toString());
                map.put(Const.NCMB_PARAM_COMMENT,obj.getString(Const.NCMB_PARAM_COMMENT));
                rankingList.add(map);
            }
        } catch (NCMBException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        // ListViewの表示
        SimpleAdapter adapter = new SimpleAdapter(getContext(), rankingList,
                android.R.layout.simple_list_item_2,
                new String[] { Const.NCMB_PARAM_RANK, Const.NCMB_PARAM_COMMENT },
                new int[] { android.R.id.text1, android.R.id.text2});
        ListView listView = view.findViewById(R.id.fragment_ranking_list);
        listView.setAdapter(adapter);

        return view;
    }

}