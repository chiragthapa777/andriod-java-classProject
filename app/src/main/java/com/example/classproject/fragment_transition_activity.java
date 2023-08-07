package com.example.classproject;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class fragment_transition_activity extends AppCompatActivity {

    Button btn_frag1;
    Button btn_frag2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transition);
        btn_frag1 = findViewById(R.id.btn_frag_1);
        btn_frag2 = findViewById(R.id.btn_frag_2);

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_transition, new fragment1("is data is passed from constructor (first fragment)"), "first_fragment_example")
                        .commit();


            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_transition, new fragment2(), "first_fragment_example")
                        .commit();
            }
        });
    }

}