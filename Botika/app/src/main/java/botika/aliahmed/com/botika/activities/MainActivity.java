package botika.aliahmed.com.botika.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.common.NavActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends NavActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        set(toolbar);
    }
}
