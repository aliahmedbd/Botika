package botika.aliahmed.com.botika.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;
import java.util.List;

import botika.aliahmed.com.botika.R;

/**
 * Created by Ali Ahmed on 3/4/2018. Email: aliahmedaiub@gmail.com
 */

public class BotCollectionAdapter extends BaseQuickAdapter<Integer> {
    List<String> headers = Arrays.asList("How about this? It will really suit your tall build and dark complexion");


    public BotCollectionAdapter(List<Integer> data) {
        super(R.layout.item_collection_single_layout, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setImageResource(R.id.imgCollection, item)
                .setText(R.id.txtCollectionHeader, headers.get(0));
    }
}

