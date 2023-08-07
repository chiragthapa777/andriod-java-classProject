package com.example.classproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static int ODD_ROW = 0;
    public static int EVEN_ROW = 1;

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ListData> values;

    public RecyclerAdapter(Context ctx, ArrayList<ListData> data){
        this.mContext = ctx;
        this.values = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == EVEN_ROW){
            View view = mInflater.inflate(R.layout.layout_list_item_view_example,parent,false);
            return new ViewHolder(view);
        }else{
            View view = mInflater.inflate(R.layout.list_item_two,parent,false);
            return new OddViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListData data = values.get(position);
        if(getItemViewType(position)== EVEN_ROW){
            ViewHolder evenHolder = (ViewHolder) holder;
            System.out.println(data.getUserName());
            evenHolder.tvInfo.setText(data.getUserName());
        }else{
            OddViewHolder oddHolder = (OddViewHolder) holder;
            oddHolder.tvInfo.setText(data.getUserName());

        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)return EVEN_ROW;
        else if(position % 2 == 0) return EVEN_ROW;
        else return ODD_ROW;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvInfo;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvInfo = itemView.findViewById(R.id.tv_info);
        }
    }

    public class OddViewHolder extends RecyclerView.ViewHolder{
        TextView tvInfo;
        public OddViewHolder(@NonNull View itemView){
            super(itemView);
            tvInfo = itemView.findViewById(R.id.tv_info_two);
        }
    }
}
