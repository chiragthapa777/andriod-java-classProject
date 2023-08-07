package com.example.classproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListOptionExampleActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnList, btnGrid, btnRecycle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_option_activity);
        btnGrid = findViewById(R.id.btn_grid);
        btnList = findViewById(R.id.btn_list);
        btnRecycle = findViewById(R.id.btn_recycle);
        btnList.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnRecycle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_list:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityListExample.class));
                break;

            case R.id.btn_grid:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityGridExample.class));
                break;

            case R.id.btn_recycle:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityRecycleExample.class));
                break;

        }
    }
}
