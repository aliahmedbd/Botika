package botika.aliahmed.com.botika.model;

/**
 * Created by Ali Ahmed on 3/2/2018. Email: aliahmedaiub@gmail.com
 */

public class ChatMessageModel {
    private String messageString;
    private boolean isFromBot;
    private boolean isFrom;
    private int type;

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
}
