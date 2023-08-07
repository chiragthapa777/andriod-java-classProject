package com.example.classproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class custom_dialog extends DialogFragment implements View.OnClickListener {
    Button btnOk, btnCancel;
    EditText firstName, lastName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog,container, false);
        firstName = view.findViewById(R.id.text_first_name);
        lastName = view.findViewById(R.id.text_last_name);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:{
                if(isValid()){
                    dismiss();
                }else{
                    return;
                }
                break;
            }
            case R.id.btn_cancel: {
                dismiss();
                break;
            }
        }
    }

    private boolean isValid(){
        if(firstName.getText().toString().isEmpty()){
            firstName.setError("First name is required");
            firstName.requestFocus();
            return false;
        }else if(lastName.getText().toString().isEmpty()){
            lastName.setError("Last name is required");
            lastName.requestFocus();
            return false;
        }
        return true;
    }
}
