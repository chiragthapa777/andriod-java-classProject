package com.example.classproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button goToSecond ;
    TextView childResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToSecond = findViewById(R.id.goToSecond);
        childResult = findViewById(R.id.childResult);
        goToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                intent.putExtra("name", "chirag");
                intent.putExtra("age", 21);
//                startActivity(intent);
                startActivityForResult(intent, 30);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 30){
                if(data!=null){
                    if(data.hasExtra("completedData")){
                        String str = data.getStringExtra("completedData");
                        System.out.println(str);
                        childResult.setText(str);
                    }
                }
            }
        }
//        else if( resultCode == Activity.RESULT_CANCELED){
//         RESULT_CANCELED =  0
//        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}