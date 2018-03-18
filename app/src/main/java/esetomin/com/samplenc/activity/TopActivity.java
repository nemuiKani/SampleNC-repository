package esetomin.com.samplenc.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import esetomin.com.samplenc.R;
import esetomin.com.samplenc.fragment.EditFragment;

public class TopActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_edit:
                    // 入力画面用のFragment生成
                    createFragment("aaa");
                    return true;
                case R.id.navigation_format_list_numbered:
                    // ランキング画面用のFragment生成

                    return true;
                case R.id.navigation_notifications:
                    // 作者PR画面用のFragment生成

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        // 入力画面用のFragment生成
        createFragment("aaa");

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void createFragment(String screenId){
        // FragmentTransactionを生成する
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Fragmentを生成する
        EditFragment fragment = new EditFragment();
        // Fragmentを設定する
        transaction.replace(R.id.fragment_container, fragment);
        // FragmentTransactionをコミットする
        transaction.commitAllowingStateLoss();
    }

}
