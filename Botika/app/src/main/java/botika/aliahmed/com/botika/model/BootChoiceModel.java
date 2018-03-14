package botika.aliahmed.com.botika.model;

/**
 * Created by Ali Ahmed on 3/14/2018. Email: aliahmedaiub@gmail.com
 */

public class BootChoiceModel {
    private String choiceText;
    private boolean isEnabled;

    public String getChoiceText() {
        return choiceText;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
