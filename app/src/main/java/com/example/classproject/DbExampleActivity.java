package com.example.classproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classproject.db.Contact;
import com.example.classproject.db.ContactDbHelper;

public class DbExampleActivity extends AppCompatActivity {
    private EditText editName, editPhone;
    private Button btnAdd, btnShow;
    private ContactDbHelper contactDbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_example_fragment);

        editName = findViewById(R.id.edit_name);
        editName = findViewById(R.id.edit_name);
        editPhone = findViewById(R.id.edit_phone);
        btnAdd = findViewById(R.id.add_btn);
        btnShow = findViewById(R.id.show_btn);
        contactDbHelper = new ContactDbHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    Contact contact = new Contact();
                    contact.setName(editName.getText().toString());
                    contact.setPhone_number(editPhone.getText().toString());

                    contactDbHelper.addContact(contact);
                    editName.setText("");
                    editPhone.setText("");
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DbExampleActivity.this, ContactListActivity.class));
            }
        });
    }

    private boolean isValid() {
        if(editName.getText().toString().isEmpty()){
            editName.setError("Name is required!");
            editName.requestFocus();
            return false;
        } else if(editPhone.getText().toString().isEmpty()){
            editPhone.setError("Phone is required!");
            editPhone.requestFocus();
            return false;
        }
        return true;
    }
}
