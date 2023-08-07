package com.example.classproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityListExample extends AppCompatActivity {
    ListView lvData;
    private ListGridAdapter gAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);
        lvData = findViewById(R.id.ll_list);
        String[] arr={"Ram", "Aram", "Bram", "Cram","Dram", "Aram", "Bram", "Cram","Dram", "Aram", "Bram", "Cram","Dram", "Aram", "Bram", "Cram","Dram", "Aram", "Bram", "Cram","Dram", "Aram", "Bram", "Cram","Dram"};
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_list_item_view_example, R.id.tv_info, arr);
        gAdapter = new ListGridAdapter(this, listData);
//        lvData.setAdapter(adapter);
        lvData.setAdapter(gAdapter);
    }
}
