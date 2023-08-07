package com.example.classproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    Button goback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        goback = findViewById(R.id.goback);
        if(getIntent().hasExtra("name")){
            text1.setText(getIntent().getStringExtra("name"));
        }
        if(getIntent().hasExtra("age")){
            int age = getIntent().getIntExtra("age",0);
            text2.setText(String.valueOf(age));
        }
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("completedData","you came back");
                setResult(2, intent);
                finish();
            }
        });
    }
}