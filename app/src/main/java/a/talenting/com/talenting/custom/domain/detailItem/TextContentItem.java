package a.talenting.com.talenting.custom.domain.detailItem;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a.talenting.com.talenting.R;
import a.talenting.com.talenting.custom.domain.style.PaddingStyle;
import a.talenting.com.talenting.custom.domain.style.TextStyle;
import a.talenting.com.talenting.databinding.CustomDetailItemTextContentBinding;

/**
 * Created by daeho on 2017. 11. 29..
 */

public class TextContentItem implements IDetailItem{
    private final DetailItemType detailItemType = DetailItemType.TEXT_CONTENT;
    private IItemClickListener onClickListener;

    public PaddingStyle padding = new PaddingStyle(50, 50, 50, 50);

    public String content = "";
    public TextStyle contentStyle = new TextStyle(Color.BLACK);

    public boolean useBottomLine = false;

    public TextContentItem(){

    }
    public TextContentItem(String content){
        this.content = content;
    }
    public TextContentItem(String content, IItemClickListener onClickListener){
        this.content = content;
        this.onClickListener = onClickListener;
    }

    public void onClick(View v){
        if(onClickListener != null) onClickListener.run(this);
    }
    public void setOnClickListener(IItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public DetailItemType getDetailItemType() {
        return detailItemType;
    }

    @Override
    public View getLayoutView(LayoutInflater layoutInflater, ViewGroup parent) {
        CustomDetailItemTextContentBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_detail_item_text_content, parent, false);
        binding.setItem(this);

        return binding.getRoot();
    }
}
