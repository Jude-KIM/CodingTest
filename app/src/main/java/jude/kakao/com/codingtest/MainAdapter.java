package jude.kakao.com.codingtest;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

public class MainAdapter extends RecyclerArrayAdapter<String> {

    private Context context;

    public MainAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(parent);
    }

    public class ItemHolder extends BaseViewHolder<String> {
        private TextView tvTitle;

        ItemHolder(ViewGroup view) {
            super(view, R.layout.list_item);
            tvTitle = $(R.id.tv_title);
        }

        @Override
        public void setData(String data) {
            super.setData(data);
            tvTitle.setText(data);
        }
    }
}
