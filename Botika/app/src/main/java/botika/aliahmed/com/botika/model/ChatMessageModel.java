package botika.aliahmed.com.botika.model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Ali Ahmed on 3/2/2018. Email: aliahmedaiub@gmail.com
 */

public class ChatMessageModel {
    private String messageString;
    private int type;
    private String userPhoto;
    private String botChoiceHeading;
    private List<String> botOptions;
    private List<Integer> photoLink;
    private Bitmap userUploadedPhoto;


    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public String getMessageString() {
        return messageString;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getBotOptions() {
        return botOptions;
    }

    public List<Integer> getPhotoLink() {
        return photoLink;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setBotOptions(List<String> botOptions) {
        this.botOptions = botOptions;
    }

    public void setPhotoLink(List<Integer> photoLink) {
        this.photoLink = photoLink;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getBotChoiceHeading() {
        return botChoiceHeading;
    }

    public void setBotChoiceHeading(String botChoiceHeading) {
        this.botChoiceHeading = botChoiceHeading;
    }

    public Bitmap getUserUploadedPhoto() {
        return userUploadedPhoto;
    }

    public void setUserUploadedPhoto(Bitmap userUploadedPhoto) {
        this.userUploadedPhoto = userUploadedPhoto;
    }
}
