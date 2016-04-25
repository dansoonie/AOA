package com.dansoonie.tools.example.aoaexample;

import android.os.Bundle;

import com.dansoonie.tools.aoa.AoaItem;
import com.dansoonie.tools.aoa.AoaListActivity;

/**
 * Created by dansoonie on 4/16/16.
 */
@AoaItem(
        parent = ListBA.AOA_PARENT,
        title = ListBA.AOA_TITLE,
        description = ListBA.AOA_DESC
)
public class ListBA extends AoaListActivity {
    static final String AOA_PARENT = "com.dansoonie.tools.example.aoaexample.ListB";
    static final String AOA_TITLE = "List BA";
    static final String AOA_DESC = "A list inside List B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
