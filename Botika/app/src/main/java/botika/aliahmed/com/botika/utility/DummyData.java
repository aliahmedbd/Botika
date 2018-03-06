package botika.aliahmed.com.botika.utility;

import android.content.Context;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.model.ChatMessageModel;

/**
 * Created by Ali Ahmed on 3/6/2018. Email: aliahmedaiub@gmail.com
 */

public class DummyData {
    private static List<ChatMessageModel> chatMessageModels = new ArrayList<>();
    private static List<ChatMessageModel> chatMessageModelsScript2 = new ArrayList<>();

    public static List<ChatMessageModel> getDummySriptOne() {
        ChatMessageModel chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Hi " + Prefs.getString(ConstName.USER_NAME, "") + ", How can I help you today");
        List<String> options = Arrays.asList("Find matching outfit", "Get ready for an event", "Catch the latest trends", "Fashion news");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("What type of event will it be?");
        options = Arrays.asList("Wedding", "Birthday", "Party", "Other");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("No white dress then, check!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("How about a picture so I can learn more about you?");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("What a beautiful dark skin!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("What price range do you think of spending?");
        options = Arrays.asList("Luxury", "Value for money", "Affordable ", "Less expensive");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("Great Lets started!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.dress_one, R.drawable.dress_two));
        chatMessageModel.setBotChoiceHeading("How about this dress?\n" +
                "It will really suit your tall build and dark complexion\n");
        chatMessageModel.setType(2);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("good now how about a pair of shoes to match the dress?");
        options = Arrays.asList("Yes", "No", "Affordable ", "Ask me again later");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.shoe_one, R.drawable.shoe_two));
        chatMessageModel.setBotChoiceHeading("Its freezing outside so how about this pair of high heels boots?");
        chatMessageModel.setType(2);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Great, but something is still missing…I know! A purse! Want me to look for one?");
        options = Arrays.asList("Yes", "No", "Affordable ", "Ask me again later");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Another item you want me to find?");
        options = Arrays.asList("Belt", "Coat", "Jewelry  ", "Not right now");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        return chatMessageModels;
    }

    public static  List<ChatMessageModel> getScript2(){
        ChatMessageModel chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("");
        List<String> options = Arrays.asList("Find matching outfit", "Get ready for an event", "Catch the latest trends", "Fashion news");
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);
    }
}
