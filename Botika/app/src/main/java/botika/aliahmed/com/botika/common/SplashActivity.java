package botika.aliahmed.com.botika.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import botika.aliahmed.com.botika.activities.LoginActivity;
import botika.aliahmed.com.botika.activities.MainActivity;
import botika.aliahmed.com.botika.utility.ConstName;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String prefValue = Prefs.getString(ConstName.USER_NAME, "");
        Intent intent = new Intent(this, prefValue.equals("") ? LoginActivity.class : MainActivity.class);
        startActivity(intent);
        finish();
    }
}