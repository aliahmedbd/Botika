package botika.aliahmed.com.botika.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.pixplicity.easyprefs.library.Prefs;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.common.BaseActivity;
import botika.aliahmed.com.botika.utility.ConstName;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    @BindView(R.id.edtUserName)
    AppCompatEditText edtUserName;

    @BindView(R.id.edtPassword)
    AppCompatEditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        clickListeners();
    }

    public void clickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUserName.getText().toString().equals("") || edtPassword.getText().toString().equals("")) {
                    showToast("Please provide username and password.");
                } else {
                    Prefs.putString(ConstName.USER_NAME, edtUserName.getText().toString());
                    gotoNewActivity(MainActivity.class);
                }
            }
        });
    }
}
