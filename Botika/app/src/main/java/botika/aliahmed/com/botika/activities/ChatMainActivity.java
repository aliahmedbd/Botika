package botika.aliahmed.com.botika.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.adapters.ChatMessageAdapter;
import botika.aliahmed.com.botika.interfaces.ChatMessageClickListener;
import botika.aliahmed.com.botika.model.ChatMessageModel;
import botika.aliahmed.com.botika.utility.DummyData;
import botika.aliahmed.com.botika.utility.ImagePicker;
import botika.aliahmed.com.botika.utility.Utilities;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatMainActivity extends AppCompatActivity implements ChatMessageClickListener {

    private static final int PICK_IMAGE_ID = 1001;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1002;
    @BindView(R.id.rvMessageList)
    RecyclerView rvMessageList;

    @BindView(R.id.message_text)
    EditText message_text;

    @BindView(R.id.send_button)
    ImageView send_button;

    @BindView(R.id.upload_image)
    ImageView upload_image;

    private boolean isScript1 = true;
    private boolean isClickedScript2 = true;

    List<ChatMessageModel> chatMessageModels = new ArrayList<>();
    ChatMessageAdapter chatMessageAdapter;
    List<String> botChoices = new ArrayList<>();
    List<Integer> botCollections = new ArrayList<>();

    List<ChatMessageModel> chatMessageModelScript1 = new ArrayList<>();
    List<ChatMessageModel> chatMessageModelScript2 = new ArrayList<>();
    int count;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        ButterKnife.bind(this);
        setToolbar();
        setInitialization();
        setDummyData();
        setRecycleView();
        setClickListeners();
    }

    private void setInitialization() {
        DummyData dummyData = new DummyData();
        chatMessageModelScript2.clear();
        chatMessageModelScript1.clear();
        chatMessageModelScript1 = dummyData.getDummySriptOne();
        chatMessageModelScript2 = dummyData.getScript2();
    }

    public void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setClickListeners() {
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!message_text.getText().toString().equals("")) {
                    ChatMessageModel chatMessageModel = new ChatMessageModel();
                    chatMessageModel.setType(1);
                    chatMessageModel.setMessageString(message_text.getText().toString());
                    chatMessageModels.add(0, chatMessageModel);
                    chatMessageAdapter.notifyDataSetChanged();
                    message_text.setText("");
                    chatMessageModels.add(0, chatMessageModelScript1.get(++count));
                    chatMessageAdapter.notifyDataSetChanged();
                }
            }
        });

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createCameraPermission();
                    Intent chooseImageIntent = ImagePicker.getPickImageIntent(ChatMainActivity.this);
                    startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void createCameraPermission() {
        int result = ActivityCompat.checkSelfPermission(ChatMainActivity.this, Manifest.permission.CAMERA);
        if (result != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != MockPackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void setDummyData() {
        chatMessageModels.add(0, chatMessageModelScript1.get(0));
    }

    private void setRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        chatMessageAdapter = new ChatMessageAdapter(this, chatMessageModels, this);
        rvMessageList.setLayoutManager(linearLayoutManager);
        rvMessageList.setAdapter(chatMessageAdapter);
    }


    @Override
    public void onClick(View view, int position) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    chatMessageModels.add(0, chatMessageModelScript1.get(++count));
                    chatMessageAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 500);

    }

    @Override
    public void onClick(View view, int position, final int choicePosition) {
        if (isScript1) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (count == 1 && isScript1) {
                            count = -1;
                            chatMessageModelScript1.clear();
                            chatMessageModelScript1.addAll(chatMessageModelScript2);
                            chatMessageModels.add(0, chatMessageModelScript1.get(++count));
                            chatMessageAdapter.notifyDataSetChanged();
                            isScript1 = false;
                        } else {
                            chatMessageModels.add(0, chatMessageModelScript1.get(++count));
                            chatMessageAdapter.notifyDataSetChanged();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 500);
        } else {
            onClick(view, position);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_IMAGE_ID:
                if (resultCode == RESULT_OK) {
                    try {
                        bmp = ImagePicker.getImageFromResult(this, resultCode, data);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        if (data == null) {
                            bmp = ImagePicker.getImageFromResult(this, resultCode, data);
                            Uri uri = Uri.parse(Prefs.getString("cameraUri", ""));
                            if (bmp == null) {
                                bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                            }
                        } else {
                            // wait....
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ChatMessageModel chatMessageModel = new ChatMessageModel();
                    chatMessageModel.setType(4);
                    chatMessageModel.setUserUploadedPhoto(bmp);
                    chatMessageModels.add(0, chatMessageModel);
                    chatMessageAdapter.notifyDataSetChanged();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                chatMessageModels.add(0, chatMessageModelScript1.get(++count));
                                chatMessageAdapter.notifyDataSetChanged();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 500);


                }
                break;
        }
    }
}
