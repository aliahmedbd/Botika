package botika.aliahmed.com.botika.adapters;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.interfaces.ChatMessageClickListener;
import botika.aliahmed.com.botika.model.ChatMessageModel;
import botika.aliahmed.com.botika.utility.RoundedImageView;

/**
 * Created by Ali Ahmed on 3/3/2018. Email: aliahmedaiub@gmail.com
 */

public class ChatMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BOT_MESSAGE_VIEW = 0;
    private static final int USER_MESSGE_VIEW = 1;
    private static final int BOT_COLLECTION_VIEW = 2;
    private static final int BOT_CHOICE_VIEW = 3;
    private static final int USER_PHOTO_VIEW = 4;
    List<ChatMessageModel> chatMessageModels;
    public static Context context;
    private ChatMessageClickListener chatMessageClickListener;

    public ChatMessageAdapter(Context context, List<ChatMessageModel> chatMessageModels, ChatMessageClickListener chatMessageClickListener) {
        this.chatMessageModels = chatMessageModels;
        this.context = context;
        this.chatMessageClickListener = chatMessageClickListener;
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
            case USER_PHOTO_VIEW:
                bindUserPhotoView(holder, position);
                break;
            default:
                break;
        }
    }

    private void bindBotMessageView(RecyclerView.ViewHolder holder, int position) {
        final ChatMessageAdapter.BotMessageViewHolder chatMessageHolder = (ChatMessageAdapter.BotMessageViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            chatMessageHolder.bind(chatMessageModel);
        }
    }

    private void bindUserMessageView(RecyclerView.ViewHolder holder, int position) {
        final ChatMessageAdapter.UserMessageViewHolder chatMessageHolder = (ChatMessageAdapter.UserMessageViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            chatMessageHolder.bind(chatMessageModel);
        }
    }

    private void bindBotCollectionView(RecyclerView.ViewHolder holder, int position) {
        final ChatMessageAdapter.BotCollectionViewHolder botCollectionViewHolder = (ChatMessageAdapter.BotCollectionViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            botCollectionViewHolder.bind(chatMessageModel);
        }
    }

    private void bindBotBotChoiceView(RecyclerView.ViewHolder holder, int position) {
        final ChatMessageAdapter.BotChoiceViewHolder chatMessageHolder = (ChatMessageAdapter.BotChoiceViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            chatMessageHolder.bind(chatMessageModel);
        }
    }

    private void bindUserPhotoView(RecyclerView.ViewHolder holder, int position) {
        final ChatMessageAdapter.UserPhotoViewHolder chatMessageHolder = (ChatMessageAdapter.UserPhotoViewHolder) holder;
        final ChatMessageModel chatMessageModel = getItem(position);
        if (chatMessageModel != null) {
            chatMessageHolder.bind(chatMessageModel);
        }
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
            case USER_PHOTO_VIEW:
                viewHolder = createUserPhotoView(parent);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    private RecyclerView.ViewHolder createBotMessageView(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bot_message, parent, false);
        final ChatMessageAdapter.BotMessageViewHolder dataViewHolder = new ChatMessageAdapter.BotMessageViewHolder(v);
        return dataViewHolder;
    }

    private RecyclerView.ViewHolder createUserMessageView(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_message, parent, false);
        final ChatMessageAdapter.UserMessageViewHolder dataViewHolder = new ChatMessageAdapter.UserMessageViewHolder(v);
        return dataViewHolder;
    }

    private RecyclerView.ViewHolder createBotCollectionView(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bot_collections, parent, false);
        final ChatMessageAdapter.BotCollectionViewHolder dataViewHolder = new ChatMessageAdapter.BotCollectionViewHolder(v, chatMessageClickListener);
        return dataViewHolder;
    }

    private RecyclerView.ViewHolder createBotChoiceView(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bot_given_choice, parent, false);
        final ChatMessageAdapter.BotChoiceViewHolder dataViewHolder = new ChatMessageAdapter.BotChoiceViewHolder(v, chatMessageClickListener);
        return dataViewHolder;
    }


    private RecyclerView.ViewHolder createUserPhotoView(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_uploaded_photo, parent, false);
        final ChatMessageAdapter.UserPhotoViewHolder dataViewHolder = new ChatMessageAdapter.UserPhotoViewHolder(v, chatMessageClickListener);
        return dataViewHolder;
    }

    private ChatMessageModel getItem(int position) {
        return chatMessageModels.get(position);
    }

    public static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage;
        TextView txtDate;
        ImageView imgUserPhoto;
        RoundedImageView imgSenderImage;

        public UserMessageViewHolder(View itemView) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txtChatText);
            imgUserPhoto = (ImageView) itemView.findViewById(R.id.imgSenderImage);
            imgSenderImage = (RoundedImageView) itemView.findViewById(R.id.imgSenderImage);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            if (!TextUtils.isEmpty(chatMessageModel.getMessageString()))
                txtMessage.setText(chatMessageModel.getMessageString());
            imgSenderImage.setImageResource(R.drawable.girl);
        }
    }

    public static class BotMessageViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage;
        TextView txtDate;
        ImageView imgUserPhoto;

        public BotMessageViewHolder(View itemView) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txtChatText);
            imgUserPhoto = (ImageView) itemView.findViewById(R.id.imgSenderImage);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            if (!TextUtils.isEmpty(chatMessageModel.getMessageString()))
                txtMessage.setText(chatMessageModel.getMessageString());
            int adapterPosition = getAdapterPosition();
            imgUserPhoto.setImageResource(R.drawable.bot_image);
        }
    }

    public static class BotChoiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ChatMessageClickListener chatMessageClickListener;
        TextView txtChoiceHeader;
        TextView txtDate;
        RecyclerView rvBotOptions;
        RoundedImageView imgSenderImage;

        public BotChoiceViewHolder(View itemView, ChatMessageClickListener chatMessageClickListener) {
            super(itemView);
            txtChoiceHeader = (TextView) itemView.findViewById(R.id.txtChoiceHeader);
            rvBotOptions = (RecyclerView) itemView.findViewById(R.id.rvBotOptions);
            imgSenderImage = (RoundedImageView) itemView.findViewById(R.id.imgSenderImage);
            this.chatMessageClickListener = chatMessageClickListener;
            itemView.setOnClickListener(this);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            if (!TextUtils.isEmpty(chatMessageModel.getBotChoiceHeading()))
                txtChoiceHeader.setText(chatMessageModel.getBotChoiceHeading());
            int adapterPosition = getAdapterPosition();
            imgSenderImage.setImageResource(R.drawable.bot_image);
            BotChoiceOptionAdapter botChoiceOptionAdapter = new BotChoiceOptionAdapter(chatMessageModel.getBotOptions());
            rvBotOptions.setLayoutManager(new LinearLayoutManager(context));
            rvBotOptions.setAdapter(botChoiceOptionAdapter);

            botChoiceOptionAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    chatMessageClickListener.onClick(itemView, getAdapterPosition());
                }
            });
        }


        @Override
        public void onClick(View v) {
            chatMessageClickListener.onClick(itemView, getAdapterPosition());
        }
    }

    public static class BotCollectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtLike, txtDontLike, txtNext;
        RecyclerView rvBotCollection;
        ChatMessageClickListener chatMessageClickListener;

        public BotCollectionViewHolder(View itemView, ChatMessageClickListener chatMessageClickListener) {
            super(itemView);
            this.chatMessageClickListener = chatMessageClickListener;
            txtLike = (TextView) itemView.findViewById(R.id.txtLike);
            txtDontLike = (TextView) itemView.findViewById(R.id.txtDontLike);
            txtNext = (TextView) itemView.findViewById(R.id.txtNext);
            rvBotCollection = (RecyclerView) itemView.findViewById(R.id.rvCollectionList);
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(rvBotCollection);
            itemView.setOnClickListener(this);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            BotCollectionAdapter botChoiceOptionAdapter = new BotCollectionAdapter(chatMessageModel.getPhotoLink());
            rvBotCollection.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            rvBotCollection.setAdapter(botChoiceOptionAdapter);

            botChoiceOptionAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    chatMessageClickListener.onClick(itemView, getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
            chatMessageClickListener.onClick(itemView, getAdapterPosition());
        }
    }

    public static class UserPhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUserPhoto;
        RoundedImageView imgSenderImage;

        public UserPhotoViewHolder(View itemView, ChatMessageClickListener chatMessageClickListener) {
            super(itemView);
            imgUserPhoto = (ImageView) itemView.findViewById(R.id.userUploadedPhoto);
            imgSenderImage = (RoundedImageView) itemView.findViewById(R.id.imgSenderImage);
        }

        private void bind(ChatMessageModel chatMessageModel) {
            imgUserPhoto.setImageBitmap(chatMessageModel.getUserUploadedPhoto());
            imgSenderImage.setImageResource(R.drawable.bot_image);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return chatMessageModels.get(position).getType();
    }

    public List<ChatMessageModel> getData() {
        return chatMessageModels;
    }


}

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
