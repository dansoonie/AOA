package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dansoonie.tools.aoa.AoaItem;

/**
 * Created by dansoonie on 4/16/16.
 */
@AoaItem(
        parent = ActivityA2.AOA_PARENT,
        title = ActivityA2.AOA_TITLE,
        description = ActivityA2.AOA_DESC
)
public class ActivityA2 extends AppCompatActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.ListA";
    static final String AOA_TITLE = "Activity A2";
    static final String AOA_DESC = "Yet, another Activity(not a list) in List A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(AOA_DESC);
    }
}
