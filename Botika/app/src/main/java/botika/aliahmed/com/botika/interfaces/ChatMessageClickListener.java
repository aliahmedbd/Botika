package botika.aliahmed.com.botika.interfaces;

import android.view.View;

/**
 * Created by Ali Ahmed on 3/6/2018. Email: aliahmedaiub@gmail.com
 */

public interface ChatMessageClickListener {
    void onClick(View view, int position);
    void onClick(View view, int position, int choicePosition);
}
