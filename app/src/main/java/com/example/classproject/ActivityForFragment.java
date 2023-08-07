package com.example.classproject;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityForFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragment);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new layout_fragment(), "first_fragment_example")
                .commit();
    }
}