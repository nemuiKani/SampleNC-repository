package esetomin.com.samplenc.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import esetomin.com.samplenc.R;
import esetomin.com.samplenc.fragment.EditFragment;
import esetomin.com.samplenc.fragment.NotificationFragment;
import esetomin.com.samplenc.fragment.RankingFragment;

public class TopActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // 選択に応じてFragmentを表示
            createFragment(item.getItemId()) ;
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        // 入力画面用を表示
        createFragment(R.id.navigation_edit);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void createFragment(int screenId){
        // FragmentTransactionを生成する
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Fragmentを生成する
        Fragment fragment = null;
        switch (screenId) {
            case R.id.navigation_edit:
                // 入力画面用のFragment生成
                fragment = new EditFragment();
                break;
            case R.id.navigation_format_list_numbered:
                // ランキング画面用のFragment生成
                fragment = new RankingFragment();
                break;
            case R.id.navigation_notifications:
                // 作者PR画面用のFragment生成
                fragment = new NotificationFragment();
                break;
        }
        // Fragmentを設定する
        transaction.replace(R.id.fragment_container, fragment);
        // FragmentTransactionをコミットする
        transaction.commitAllowingStateLoss();
    }

}
