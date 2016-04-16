package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;

import com.dansoonie.tools.aoa.AoaItem;
import com.dansoonie.tools.aoa.AoaListActivity;

@AoaItem(
        parent = ListC.AOA_PARENT,
        title = ListC.AOA_TITLE,
        description = ListC.AOA_DESC
)
public class ListC extends AoaListActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.MainActivity";
    static final String AOA_TITLE = "List C";
    static final String AOA_DESC = "Yet, on final list in Root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
