package botika.aliahmed.com.botika.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import botika.aliahmed.com.botika.R;
import botika.aliahmed.com.botika.model.BootChoiceModel;

/**
 * Created by Ali Ahmed on 3/4/2018. Email: aliahmedaiub@gmail.com
 */

public class BotChoiceOptionAdapter extends BaseQuickAdapter<BootChoiceModel> {


    public BotChoiceOptionAdapter(List<BootChoiceModel> data) {
        super(R.layout.item_single_option_layout, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, BootChoiceModel item) {
        helper.setText(R.id.txtChoice, item.getChoiceText());

        if (item.isEnabled()) {
            helper.setAlpha(R.id.layoutOptions, 1);
        } else {
            helper.setAlpha(R.id.layoutOptions, 0.5f);
        }
    }
}
