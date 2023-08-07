package com.example.classproject;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Toolbar toolbar;
    Button btnPopMenu, btnContextMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        toolbar = findViewById(R.id.toolbar);
        btnPopMenu = findViewById(R.id.popUpMenu);
        btnContextMenu = findViewById(R.id.contextMenu);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        registerForContextMenu(btnContextMenu); // have to long press

        btnPopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                Toast.makeText(this, "you clicked delete options toolbar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_edit:
                Toast.makeText(this, "you clicked edit options toolbar", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                Toast.makeText(this, "you clicked delete context", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_edit:
                Toast.makeText(this, "you clicked edit context", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
        }
        return super.onContextItemSelected(item);
    }

    private void showPopMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.dashboard_menu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                Toast.makeText(this, "you clicked delete popupmeu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_edit:
                Toast.makeText(this, "you clicked edit popupmenu", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
        }
        return true;
    }
}
