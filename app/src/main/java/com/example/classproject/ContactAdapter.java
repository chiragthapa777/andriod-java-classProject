package com.example.classproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classproject.db.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context mcontext;
    private LayoutInflater mInflater;
    private ArrayList<Contact> contacts;
    private ContactClickListener mListener;

    public ContactAdapter(Context mcontext, ArrayList<Contact> contacts, ContactClickListener mListener){
        this.mcontext = mcontext;
        this.contacts = contacts;
        this.mListener = mListener;
        this.mInflater = LayoutInflater.from(mcontext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contact_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact = contacts.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone_number());
        holder.llMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(position);
                return true;
            }
        });


    }

    private void showDialog(int position){
        String options[] = new String[]{"Update", "Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
        builder.setTitle("Select Options").setSingleChoiceItems(options, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:{
                        if(mListener!=null){
                            mListener.onContactUpdate(position);
                        }
                        break;
                    }
                    case 1:{
                        confirmDelete(position);
                        break;
                    }
                }
                dialog.dismiss();
            }
        });
    }

    private void confirmDelete(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
        builder.setTitle("Delete Contact").setMessage("Are you sure you want to delete?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mListener != null){
                    mListener.onContactDelete(position);
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPhone;
        LinearLayout llMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            llMain = itemView.findViewById(R.id.llmain);
        }
    }
}
