package botika.aliahmed.com.botika.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;

import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import botika.aliahmed.com.botika.utility.TypefaceUtil;

/**
 * Created by Ali Ahmed on 3/1/2018. Email: aliahmedaiub@gmail.com
 */

public class BotikaAppController extends Application {

    public static final String LOG_TAG = "MyApp";

    public boolean wasInBackground = true;

    private Timer mActivityTransitionTimer;
    private TimerTask mActivityTransitionTimerTask;
    private final long MAX_ACTIVITY_TRANSITION_TIME_MS = 2000;

    @Override
    public void onCreate() {
        super.onCreate();

        Picasso.Builder builder = new Picasso.Builder(this);
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Quicksand-Regular.ttf", "fonts/Quicksand-Regular.ttf", "fonts/Quicksand-Regular.ttf");
    }
}
