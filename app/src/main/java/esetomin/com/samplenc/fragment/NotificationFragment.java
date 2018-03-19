package esetomin.com.samplenc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import esetomin.com.samplenc.R;

/**
 * 作者情報画面のフラグメント。
 *
 * @author nemuiKani
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