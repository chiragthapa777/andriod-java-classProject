package com.example.classproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

@SuppressLint("ValidFragment")
public class fragment1 extends Fragment {

    public String txt;
    private TextView textView;

    @SuppressLint("ValidFragment")
    public fragment1(String text){
        this.txt = text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1,container, false);
        textView = view.findViewById(R.id.frag_1_text);
        textView.setText(txt);
        return view;
    }
}