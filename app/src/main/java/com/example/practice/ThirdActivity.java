package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    RecyclerView rcv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rcv=findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        String arr[]={"c","c++","java","c#","c","c++","java","c#","c","c++","java","c#"};
        rcv.setAdapter(new myAdapter(arr));
    }
}