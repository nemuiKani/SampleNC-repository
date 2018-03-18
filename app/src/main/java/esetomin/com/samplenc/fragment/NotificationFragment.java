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

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import esetomin.com.samplenc.R;
import esetomin.com.samplenc.common.Const;

/**
 * 作者情報画面のフラグメント。
 *
 * @author Taro
 * @version 1.0
 */
public class NotificationFragment extends Fragment {

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
        final View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        return view;
    }

}