package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;

import com.dansoonie.tools.aoa.AoaItem;
import com.dansoonie.tools.aoa.AoaListActivity;

@AoaItem(
        parent = ListB.AOA_PARENT,
        title = ListB.AOA_TITLE,
        description = ListB.AOA_DESC
)
public class ListB extends AoaListActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.MainActivity";
    static final String AOA_TITLE = "List B";
    static final String AOA_DESC = "Another list in Root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
