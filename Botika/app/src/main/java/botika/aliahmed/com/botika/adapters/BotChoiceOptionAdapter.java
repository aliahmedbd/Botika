package botika.aliahmed.com.botika.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import botika.aliahmed.com.botika.R;

/**
 * Created by Ali Ahmed on 3/4/2018. Email: aliahmedaiub@gmail.com
 */

public class BotChoiceOptionAdapter extends BaseQuickAdapter<String> {


    public BotChoiceOptionAdapter(List<String> data) {
        super(R.layout.item_single_option_layout, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.txtChoice, item);
    }
}
