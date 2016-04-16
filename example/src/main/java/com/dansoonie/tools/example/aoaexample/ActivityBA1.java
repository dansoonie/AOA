package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dansoonie.tools.aoa.AoaItem;

/**
 * Created by dansoonie on 4/16/16.
 */
@AoaItem(
        parent = ActivityBA1.AOA_PARENT,
        title = ActivityBA1.AOA_TITLE,
        description = ActivityBA1.AOA_DESC
)
public class ActivityBA1 extends AppCompatActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.ListBA";
    static final String AOA_TITLE = "Activity BA1";
    static final String AOA_DESC = "Activity(not a list) in List BA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(AOA_DESC);
    }
}
