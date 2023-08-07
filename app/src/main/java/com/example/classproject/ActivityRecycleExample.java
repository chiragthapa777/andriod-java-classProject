package com.example.classproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityRecycleExample extends AppCompatActivity {
    RecyclerView rvData;
    RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycle_view_example);
        rvData = findViewById(R.id.rv_recycler);
//        rvData.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        rvData.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvData.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<ListData> listData = new ArrayList<>();
        listData.add(new ListData("","Ram 1"));
        listData.add(new ListData("","ARam 2"));
        listData.add(new ListData("","BRam 3"));
        listData.add(new ListData("","CRam 4"));
        listData.add(new ListData("","DRam 4"));
        listData.add(new ListData("","ERam 5"));
        listData.add(new ListData("","FRam 6"));
        listData.add(new ListData("","GRam 7"));
        listData.add(new ListData("","HRam 8"));
        listData.add(new ListData("","JRam 9"));
        listData.add(new ListData("","Ram 1"));
        listData.add(new ListData("","ARam 2"));
        listData.add(new ListData("","BRam 3"));
        listData.add(new ListData("","CRam 4"));
        listData.add(new ListData("","DRam 4"));
        listData.add(new ListData("","ERam 5"));
        listData.add(new ListData("","FRam 6"));
        listData.add(new ListData("","GRam 7"));
        listData.add(new ListData("","HRam 8"));
        listData.add(new ListData("","JRam 9"));
        listData.add(new ListData("","Ram 1"));
        listData.add(new ListData("","ARam 2"));
        listData.add(new ListData("","BRam 3"));
        listData.add(new ListData("","CRam 4"));
        listData.add(new ListData("","DRam 4"));
        listData.add(new ListData("","ERam 5"));
        listData.add(new ListData("","FRam 6"));
        listData.add(new ListData("","GRam 7"));
        listData.add(new ListData("","HRam 8"));
        listData.add(new ListData("","JRam 9"));
        listData.add(new ListData("","Ram 1"));
        listData.add(new ListData("","ARam 2"));
        listData.add(new ListData("","BRam 3"));
        listData.add(new ListData("","CRam 4"));
        listData.add(new ListData("","DRam 4"));
        listData.add(new ListData("","ERam 5"));
        listData.add(new ListData("","FRam 6"));
        listData.add(new ListData("","GRam 7"));
        listData.add(new ListData("","HRam 8"));
        listData.add(new ListData("","JRam 9"));
        listData.add(new ListData("","Ram 1"));
        listData.add(new ListData("","ARam 2"));
        listData.add(new ListData("","BRam 3"));
        listData.add(new ListData("","CRam 4"));
        listData.add(new ListData("","DRam 4"));
        listData.add(new ListData("","ERam 5"));
        listData.add(new ListData("","FRam 6"));
        listData.add(new ListData("","GRam 7"));
        listData.add(new ListData("","HRam 8"));
        listData.add(new ListData("","JRam 9"));
        mAdapter = new RecyclerAdapter(this,listData);
        rvData.setAdapter(mAdapter);
    }
}
