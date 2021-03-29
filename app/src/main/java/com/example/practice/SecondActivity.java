package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private int mcount=0;
    private TextView mshowcount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mshowcount=(TextView)findViewById(R.id.show_count);

    }




    public void countUpClick(View view) {
        mcount++;
        if(mcount!=0){
            mshowcount.setText(Integer.toString(mcount));
        }

    }

    public void showToastMessage(View view) {
        Toast.makeText(getApplicationContext(),"Hello this is toast message",Toast.LENGTH_SHORT).show();
    }
}