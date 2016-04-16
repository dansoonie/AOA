package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dansoonie.tools.aoa.AoaItem;

@AoaItem(
        parent = Activity1.AOA_PARENT,
        title = Activity1.AOA_TITLE,
        description = Activity1.AOA_DESC
)
public class Activity1 extends AppCompatActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.MainActivity";
    static final String AOA_TITLE = "Activity 1";
    static final String AOA_DESC = "An Activity(not a list) in root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(AOA_DESC);
    }
}
