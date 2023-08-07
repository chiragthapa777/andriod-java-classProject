package com.example.classproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivityDialogExample extends AppCompatActivity implements View.OnClickListener {

    Button alertBtn, datePickerBtn, timePickerBtn, customDialogBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        alertBtn = findViewById(R.id.btn_alert);
        datePickerBtn = findViewById(R.id.btn_datePicker);
        timePickerBtn = findViewById(R.id.btn_timePicker);
        customDialogBtn = findViewById(R.id.btn_customDialog);

        alertBtn.setOnClickListener(this);
        datePickerBtn.setOnClickListener(this);
        timePickerBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);


    }

    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Title");
        builder.setMessage("This is a alert message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Do positive action");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Do negative action");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void showDatePicker(){
        Calendar cal = Calendar.getInstance();
        System.out.println("Data : "+cal.get(Calendar.YEAR));
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String msg = "Date : " + year + "/" + month + "/" + dayOfMonth;
                Toast.makeText(ActivityDialogExample.this,msg, Toast.LENGTH_SHORT).show();
            }
        },cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }

    private void showTimePicker(){
        Calendar cal = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String msg = "Time : " + hourOfDay + ":" + minute ;
                Toast.makeText(ActivityDialogExample.this,msg, Toast.LENGTH_SHORT).show();
            }
        },10, cal.get(Calendar.MINUTE), false);
        dialog.show();
    }

    private void showCustomDialog(){
        custom_dialog dialog = new custom_dialog();
        dialog.show(getSupportFragmentManager(), "Custom dialog");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert:{
                showAlertDialog();
                break;
            }
            case R.id.btn_customDialog:{
                showCustomDialog();
                break;
            }
            case R.id.btn_datePicker:{
                showDatePicker();
                break;
            }
            case R.id.btn_timePicker:{
                showTimePicker();
                break;
            }
        }
    }
}
