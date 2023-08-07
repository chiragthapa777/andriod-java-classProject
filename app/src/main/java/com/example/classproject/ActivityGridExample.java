package com.example.classproject;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityGridExample  extends AppCompatActivity {
    GridView gridView;
    private ListGridAdapter gAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grid_view_example);
        gridView = findViewById(R.id.ll_grid_view);
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
        System.out.println("Yeta aayooooo");
        gAdapter = new ListGridAdapter(this, listData);
        gridView.setAdapter(gAdapter);
    }
}
