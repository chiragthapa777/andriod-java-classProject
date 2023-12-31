package com.example.classproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListGridAdapter extends ArrayAdapter<ListData> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ListData> data;


    public ListGridAdapter(@NonNull Context context, @NonNull List<ListData> objects) {
        super(context, R.layout.layout_list_item_view_example, objects);

        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        data = (ArrayList<ListData>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        ListData item = data.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_list_item_view_example, parent, false);
            holder.tvInfo = convertView.findViewById(R.id.tv_info);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.tvInfo.setText(item.getUserName());

        return convertView;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public class ViewHolder {
        public TextView tvInfo;
    }
}