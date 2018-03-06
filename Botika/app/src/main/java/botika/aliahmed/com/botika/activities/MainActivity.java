package botika.aliahmed.com.botika.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.common.NavActivity;
import botika.aliahmed.com.botika.utility.ConstName;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends NavActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btnChatWithMe)
    Button btnChatWithMe;

    @BindView(R.id.txtWelcomeText)
    TextView txtWelcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        set(toolbar);
        setInitialization();
        setClickListeners();
    }

    private void setInitialization() {
        txtWelcomeText.setText("Hi " + Prefs.getString(ConstName.USER_NAME, "") + ", I am BOTiKA");
    }

    private void setClickListeners() {
        btnChatWithMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNewActivity(ChatMainActivity.class);
            }
        });
    }
}
