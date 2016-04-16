package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;

import com.dansoonie.tools.aoa.AoaItem;
import com.dansoonie.tools.aoa.AoaListActivity;

@AoaItem (
        title = MainActivity.AOA_TITLE,
        description = MainActivity.AOA_DESC
)
public class MainActivity extends AoaListActivity {
    static final String AOA_TITLE = "Root";
    static final String AOA_DESC = "This is the root of all list and activities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
