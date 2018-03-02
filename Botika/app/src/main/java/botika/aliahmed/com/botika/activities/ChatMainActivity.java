package botika.aliahmed.com.botika.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.adapters.ChatMessageAdapter;
import botika.aliahmed.com.botika.model.ChatMessageModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatMainActivity extends AppCompatActivity {

    @BindView(R.id.rvMessageList)
    RecyclerView rvMessageList;

    List<ChatMessageModel> chatMessageModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        ButterKnife.bind(this);
        setDummyData();
        setRecycleView();
    }

    private void setDummyData(){
        for (int i = 0; i < 3; i++) {
            ChatMessageModel chatMessageModel = new ChatMessageModel();
            chatMessageModel.setMessageString("Hello bootika I need you help. Can you please help me out? "+i);
            chatMessageModel.setType(1);
            chatMessageModels.add(chatMessageModel);
        }
    }

    private void setRecycleView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        ChatMessageAdapter chatMessageAdapter = new ChatMessageAdapter(chatMessageModels);
        rvMessageList.setLayoutManager(linearLayoutManager);
        rvMessageList.setAdapter(chatMessageAdapter);
    }


}
