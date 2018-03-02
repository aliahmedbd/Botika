package botika.aliahmed.com.botika.adapters;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.model.ChatMessageModel;

import static botika.aliahmed.com.botika.adapters.BaseAdapter.HEADER_VIEW;
import static botika.aliahmed.com.botika.adapters.BaseAdapter.ITEM_VIEW;

/**
 * Created by Ali Ahmed on 3/3/2018. Email: aliahmedaiub@gmail.com
 */

public class ChatMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BOT_MESSAGE_VIEW = 0;
    private static final int USER_MESSGE_VIEW = 1;
    private static final int BOT_COLLECTION_VIEW = 2;
    private static final int BOT_CHOICE_VIEW = 3;
    List<ChatMessageModel> chatMessageModels;

    public ChatMessageAdapter(List<ChatMessageModel> chatMessageModels) {
        this.chatMessageModels = chatMessageModels;
    }


    @Override
    public int getItemCount() {
        return chatMessageModels.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BOT_MESSAGE_VIEW:
                bindBotMessageView(holder, position);
                break;
            case USER_MESSGE_VIEW:
                bindUserMessageView(holder, position);
                break;
            case BOT_COLLECTION_VIEW:
                bindBotCollectionView(holder, position);
                break;
            case BOT_CHOICE_VIEW:
                bindBotBotChoiceView(holder, position);
                break;
            default:
                break;
        }
    }

    public void bindBotMessageView(RecyclerView.ViewHolder holder, int position){

    }
    public void bindUserMessageView(RecyclerView.ViewHolder holder, int position){
        final ChatMessageAdapter.UserMessageViewHolder  chatMessageHolder= (ChatMessageAdapter.UserMessageViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            chatMessageHolder.bind(chatMessageModel);
        }
    }

    public void bindBotCollectionView(RecyclerView.ViewHolder holder, int position){

    }

    public void bindBotBotChoiceView(RecyclerView.ViewHolder holder, int position){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case BOT_MESSAGE_VIEW:
                viewHolder = createBotMessageView(parent);
                break;
            case USER_MESSGE_VIEW:
                viewHolder = createUserMessageView(parent);
                break;
            case BOT_COLLECTION_VIEW:
                viewHolder = createBotCollectionView(parent);
                break;
            case BOT_CHOICE_VIEW:
                viewHolder = createBotChoiceView(parent);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    public RecyclerView.ViewHolder createBotMessageView(ViewGroup parent){
        return null;
    }

    public RecyclerView.ViewHolder createUserMessageView(ViewGroup parent){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_message, parent, false);

        final ChatMessageAdapter.UserMessageViewHolder dataViewHolder = new ChatMessageAdapter.UserMessageViewHolder(v);

//        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int adapterPosition = dataViewHolder.getAdapterPosition();
//                if (adapterPosition != RecyclerView.NO_POSITION) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClick(adapterPosition, dataViewHolder.itemView);
//                    }
//                }
//            }
//        });
        return dataViewHolder;
    }

    public ChatMessageModel getItem(int position) {
        return chatMessageModels.get(position);
    }


    public RecyclerView.ViewHolder createBotCollectionView(ViewGroup parent){
        return null;
    }


    public RecyclerView.ViewHolder createBotChoiceView(ViewGroup parent){
        return null;
    }

    public static class UserMessageViewHolder extends RecyclerView.ViewHolder {

        TextView txtMessage;
        TextView txtDate;
        ImageView imgUserPhoto;

        public UserMessageViewHolder(View itemView) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txtChatText);
            imgUserPhoto = (ImageView) itemView.findViewById(R.id.imgSenderImage);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            if (!TextUtils.isEmpty(chatMessageModel.getMessageString()))
                txtMessage.setText(chatMessageModel.getMessageString());
            int adapterPosition = getAdapterPosition();
//            ViewCompat.setTransitionName(txtName, "My Transition " + adapterPosition);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return chatMessageModels.get(position).getType();
    }


}
