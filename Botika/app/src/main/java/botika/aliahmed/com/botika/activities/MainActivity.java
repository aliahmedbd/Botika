package botika.aliahmed.com.botika.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import java.io.ByteArrayOutputStream;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.common.NavActivity;
import botika.aliahmed.com.botika.utility.ConstName;
import botika.aliahmed.com.botika.utility.ImagePicker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends NavActivity {
    private static final int PICK_IMAGE_ID = 1001;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1002;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btnChatWithMe)
    Button btnChatWithMe;

    @BindView(R.id.txtWelcomeText)
    TextView txtWelcomeText;

    @BindView(R.id.imUserPhoto)
    ImageView imUserPhoto;
    private Bitmap bmp;

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

        imUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCameraPermission();
                Intent chooseImageIntent = ImagePicker.getPickImageIntent(MainActivity.this);
                startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_IMAGE_ID:
                if (resultCode == RESULT_OK) {
                    bmp = ImagePicker.getImageFromResult(this, resultCode, data);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    if (data == null) {
                        bmp = ImagePicker.getImageFromResult(this, resultCode, data);
                        Uri uri = Uri.parse(Prefs.getString("cameraUri", ""));
                    } else {
                        // wait....
                    }

                }
                imUserPhoto.setImageBitmap(bmp);
                break;
        }
    }

    private void createCameraPermission() {
        int result = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if (result != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != MockPackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
            }
        }
    }
}
