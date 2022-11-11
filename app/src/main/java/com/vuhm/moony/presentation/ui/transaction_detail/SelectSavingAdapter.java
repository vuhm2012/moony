package com.vuhm.moony.presentation.ui.transaction_detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;
import com.vuhm.moony.domain.model.Saving;

import java.util.List;

public class SelectSavingAdapter extends BaseAdapter {

    private Context context;
    private List<Saving> savings;
    private OnItemClick<Saving> listener;

    public SelectSavingAdapter(
            Context context,
            List<Saving> savings,
            OnItemClick listener
    ) {
        this.context = context;
        this.savings = savings;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return savings.size();
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
        TextView title;
        title = view.findViewById(R.id.lb_title);
        title.setText(savings.get(i).getTitle());
        return view;
    }
}
