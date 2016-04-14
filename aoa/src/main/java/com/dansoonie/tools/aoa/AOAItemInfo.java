package com.dansoonie.tools.aoa;

import android.content.Intent;

import java.util.Comparator;

/**
 * Created by dansoonie on 4/13/16.
 */
class AOAItemInfo {
    private Intent mIntent;
    private String mTitle;
    private String mDescription;

    AOAItemInfo(Intent intent, String title, String description) {
        mIntent = intent;
        mTitle = title;
        mDescription = description;
    }

    Intent getIntent() {
        return mIntent;
    }

    String getTitle() {
        return mTitle;
    }

    String getDescription() {
        return mDescription;
    }

    static final Comparator<AOAItemInfo> TITLE_COMPARATOR =
            new Comparator<AOAItemInfo>() {
                @Override
                public int compare(AOAItemInfo item1, AOAItemInfo item2) {
                    String title1 = (String) item1.getTitle();
                    String title2 = (String) item2.getTitle();
                    return title1.compareTo(title2);
                }
            };
}
