package botika.aliahmed.com.botika.utility;

import android.content.Context;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.model.BootChoiceModel;
import botika.aliahmed.com.botika.model.ChatMessageModel;

/**
 * Created by Ali Ahmed on 3/6/2018. Email: aliahmedaiub@gmail.com
 */

public class DummyData {
    private List<ChatMessageModel> chatMessageModels = new ArrayList<>();
    private List<ChatMessageModel> chatMessageModelsScript2 = new ArrayList<>();

    public List<ChatMessageModel> getDummySriptOne() {
        //1
        ChatMessageModel chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Hi " + Prefs.getString(ConstName.USER_NAME, "") + ", How can I help you today");
        List<BootChoiceModel> options = new ArrayList<>();
        BootChoiceModel bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Find matching outfit");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Get ready for an event");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Catch the latest trends");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Fashion news");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //2
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("What type of event will it be?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Wedding");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Birthday");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Party");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Other");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //3
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("No white dress then, check!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        //4
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("How about a picture so I can learn more about you?");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        //5
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("What a beautiful dark skin!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("What price range do you think of spending?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Luxury");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Value for money");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Affordable");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Less expensive");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //6
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("Great Lets started!");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        //7
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.dress_one, R.drawable.dress_two));
        chatMessageModel.setHeadersCollections(Arrays.asList("How about this dress?\n" +
                "It will really suit your tall build and dark complexion\n"));
        chatMessageModel.setType(2);
        chatMessageModels.add(chatMessageModel);

        //8
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("good now how about a pair of shoes to match the dress?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Yes");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("No");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);


        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Ask me again later");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //9
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.shoe_one));
        chatMessageModel.setHeadersCollections(Arrays.asList("Its freezing outside so how about this pair of high heels boots?"));
        chatMessageModel.setType(2);
        chatMessageModels.add(chatMessageModel);


        //10
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("don’t want to outshine the bride ha?\n");
        chatMessageModel.setType(0);
        chatMessageModels.add(chatMessageModel);

        //11
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.shoe_two));
        chatMessageModel.setHeadersCollections(Arrays.asList("Then How about this pair of low heels boots?\n"));
        chatMessageModel.setType(2);
        chatMessageModels.add(chatMessageModel);

        //12
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Great, but something is still missing…I know! A purse! Want me to look for one?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Yes");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("No");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Ask me again later");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //13
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Another item you want me to find?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Belt");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Coat");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Jewelry");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Not right now");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModels.add(chatMessageModel);

        //14
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.barcode));
        chatMessageModel.setHeadersCollections(Arrays.asList("You will look Beautiful!\n" +
                "Show this Barcode and get a special price\n"));
        chatMessageModel.setType(2);
        chatMessageModel.setOptionVisible(true);
        chatMessageModels.add(chatMessageModel);

        return chatMessageModels;
    }

    public List<ChatMessageModel> getScript2() {

        //1
        ChatMessageModel chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("Any dress code?");

        List<BootChoiceModel> options = new ArrayList<>();
        BootChoiceModel bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Formal");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Casual");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Sport elegant");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModelsScript2.add(chatMessageModel);

        //2
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("How about a picture so I can learn more about you?");
        chatMessageModel.setType(0);
        chatMessageModelsScript2.add(chatMessageModel);

        //3
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("What a beautiful blonde hair!");
        chatMessageModel.setType(0);
        chatMessageModelsScript2.add(chatMessageModel);

        //4
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("Lets start dressing you up!");
        chatMessageModel.setType(0);
        chatMessageModelsScript2.add(chatMessageModel);

        //5
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.suite_one));
        chatMessageModel.setHeadersCollections(Arrays.asList("How about this suit?\n" +
                "It show confidence and yet accessible\n"));
        chatMessageModel.setType(2);
        chatMessageModelsScript2.add(chatMessageModel);

        //6
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("good now how about a pair of shoes to match the suit?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Yes");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("No");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Ask me again later");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModelsScript2.add(chatMessageModel);

        //7
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.shoe_three));
        chatMessageModel.setHeadersCollections(Arrays.asList("For a formal event how about this pair?\n"));
        chatMessageModel.setType(2);
        chatMessageModelsScript2.add(chatMessageModel);

        //8
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("Thank you for helping me know your taste better\n");
        chatMessageModel.setType(0);
        chatMessageModelsScript2.add(chatMessageModel);

        //9
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setPhotoLink(Arrays.asList(R.drawable.shoe_four));
        chatMessageModel.setHeadersCollections(Arrays.asList("How about one of those  pairs?"));
        chatMessageModel.setType(2);
        chatMessageModelsScript2.add(chatMessageModel);

        //10
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("What color do you prefer?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Black");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Brown");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("off-white");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);

        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModelsScript2.add(chatMessageModel);

        //11
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setBotChoiceHeading("You will look Beautiful!\n" +
                "Want me to find where you can buy this items online?");

        options = new ArrayList<>();
        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("Yes");
        bootChoiceModel.setEnabled(true);
        options.add(bootChoiceModel);

        bootChoiceModel = new BootChoiceModel();
        bootChoiceModel.setChoiceText("No");
        bootChoiceModel.setEnabled(false);
        options.add(bootChoiceModel);
        chatMessageModel.setBotOptions(options);
        chatMessageModel.setType(3);
        chatMessageModelsScript2.add(chatMessageModel);

        //12
        chatMessageModel = new ChatMessageModel();
        chatMessageModel.setMessageString("Here’s your discount code\n" +
                "Enter it in the link below\n" +
                "http://www.h-o.co.il/");
        chatMessageModel.setType(0);
        chatMessageModelsScript2.add(chatMessageModel);


        return chatMessageModelsScript2;
    }
}
