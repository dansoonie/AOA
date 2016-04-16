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
        mIsList = AoaListActivity.class.isAssignableFrom(mClass);
        mTitle = title;
        mDescription = description;
    }

    Class getClazz() { return mClass; }

    boolean isListItem() { return mIsList; }

    String getTitle() { return mTitle; }

    String getDescription() { return mDescription; }

    static final Comparator<AoaItemInfo> TITLE_COMPARATOR =
            new Comparator<AoaItemInfo>() {
                @Override
                public int compare(AoaItemInfo item1, AoaItemInfo item2) {
                    if (item1.isListItem() == item2.isListItem()) {
                        // if both AOA items same type
                        // i.e. both list items or both not list items
                        // just compare by title
                        String title1 = (String) item1.getTitle();
                        String title2 = (String) item2.getTitle();
                        return title1.compareTo(title2);
                    } else {
                        // AOA items that are list have priority over non list items when ordering
                        // So that lists appear first
                        return item1.isListItem()? -1 : 1;
                    }

                }
            };
}
