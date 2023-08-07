package com.example.classproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classproject.db.Contact;
import com.example.classproject.db.ContactDbHelper;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity implements ContactClickListener {
    RecyclerView rvContacts;
    private ContactAdapter mAdapter;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_data_item);
        rvContacts = findViewById(R.id.rv_data);
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        contacts = (ArrayList<Contact>)  contactDbHelper.getAllContacts();
        mAdapter = new ContactAdapter(this,
                contacts, this);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        rvContacts.setAdapter(mAdapter);
    }

    @Override
    public void onContactDelete(int position) {
        contacts.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onContactUpdate(int position) {
        showUpdateDialog(position);
    }

    private void showUpdateDialog(int position) {
        EditText editName, editPhone;
        Button btnOk, btnCancel;
        View view = LayoutInflater.from(this).inflate(R.layout.contact_update_dialog, null, false);
        editName = view.findViewById(R.id.edt_name);
        editPhone = view.findViewById(R.id.edt_phone);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().isEmpty()){
                    editName.setError("Please enter name");
                    editName.requestFocus();
                }else if (editPhone.getText().toString().isEmpty()){
                    editPhone.setError("Please enter phone number");
                    editPhone.requestFocus();
                }else {
                    Contact addData = new Contact(editName.getText().toString(), editPhone.getText().toString());
                    contacts.remove(position);
                    contacts.add(position, addData);
                    mAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
