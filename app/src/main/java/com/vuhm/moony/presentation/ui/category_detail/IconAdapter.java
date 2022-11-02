package com.vuhm.moony.presentation.ui.category_detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.vuhm.moony.R;
import com.vuhm.moony.domain.model.CategoryIcon;

import java.util.List;

public class IconAdapter extends BaseAdapter {
    private List<CategoryIcon> icons;
    private Context context;

    public IconAdapter(List<CategoryIcon> icons, Context context) {
        this.icons = icons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return icons.size();
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
            view = inflater.inflate(R.layout.item_icon, null);
        }
        ImageView icon;
        icon = view.findViewById(R.id.icon);
        icon.setImageResource(icons.get(i).getIconResId());
        return view;
    }
}
