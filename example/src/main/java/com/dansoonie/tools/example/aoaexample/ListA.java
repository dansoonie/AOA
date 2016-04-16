package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;

import com.dansoonie.tools.aoa.AoaItem;
import com.dansoonie.tools.aoa.AoaListActivity;

@AoaItem (
        parent = ListA.AOA_PARENT,
        title = ListA.AOA_TITLE,
        description = ListA.AOA_DESC
)
public class ListA extends AoaListActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.MainActivity";
    static final String AOA_TITLE = "List A";
    static final String AOA_DESC = "Another list in Root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
