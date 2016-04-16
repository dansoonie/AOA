package com.dansoonie.tools.aoa;

import java.util.Comparator;

/**
 * Created by dansoonie on 4/13/16.
 */
class AoaItemInfo {
    private Class mClass;
    private boolean mIsList;
    private String mTitle;
    private String mDescription;

    AoaItemInfo(Class clazz, String title, String description) {
        mClass = clazz;
        mIsList = mClass.isAssignableFrom(AoaListActivity.class);
        mTitle = title;
        mDescription = description;
    }

    Class getClazz() { return mClass; }

    String getTitle() {
        return mTitle;
    }

    String getDescription() {
        return mDescription;
    }

    static final Comparator<AoaItemInfo> TITLE_COMPARATOR =
            new Comparator<AoaItemInfo>() {
                @Override
                public int compare(AoaItemInfo item1, AoaItemInfo item2) {
                    String title1 = (String) item1.getTitle();
                    String title2 = (String) item2.getTitle();
                    return title1.compareTo(title2);
                }
            };
}
