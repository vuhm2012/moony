package com.vuhm.moony.presentation.ui.transaction_detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuhm.moony.R;
import com.vuhm.moony.domain.model.Category;

import java.util.List;

public class SelectCategoryAdapter extends BaseAdapter {

    private List<Category> categories;
    private Context context;

    public SelectCategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_select_category, null);
        }
        ImageView icon;
        TextView title;
        icon = view.findViewById(R.id.img_icon);
        title = view.findViewById(R.id.lb_title);
        icon.setImageResource(categories.get(i).getIconResId());
        title.setText(categories.get(i).getTitle());
        return view;
    }
}
