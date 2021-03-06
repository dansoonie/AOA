package com.dansoonie.tools.aoa;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dansoonie on 4/14/16.
 */
public class AoaListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List list = createActivityList();
        setListAdapter(createListAdapter(list));
    }

    private List<AoaItemInfo> createActivityList() {
        List<AoaItemInfo> activityList = new ArrayList<>();

        try {
            PackageManager pkgManager = getPackageManager();
            String pkgName = getPackageName();
            PackageInfo pkgInfo = pkgManager.getPackageInfo(pkgName, PackageManager.GET_ACTIVITIES);
            for (ActivityInfo activityInfo : pkgInfo.activities) {
                // Get AoaItem info
                Class<?> clazz = Class.forName(activityInfo.name);
                AoaItem aoa = clazz.getAnnotation(AoaItem.class);

                // If activity's parent is this list activity add to list
                if (aoa != null && getClass().getName().equals(aoa.parent())) {
                    String title = aoa.title();
                    String description = aoa.description();
                    activityList.add(new AoaItemInfo(clazz, title, description));
                }
            }
        } catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        Collections.sort(activityList, AoaItemInfo.TITLE_COMPARATOR);
        return activityList;
    }

    protected ListAdapter createListAdapter(List list) {
        final ArrayAdapter listAdapter = new ArrayAdapter<AoaItemInfo>(this, R.layout.aoa_list_item) {

            private LayoutInflater mInflater;

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    if (mInflater == null) {
                        mInflater = getLayoutInflater();
                    }
                    convertView = mInflater.inflate(R.layout.aoa_list_item, parent, false);
                }
                View itemRootView = (View)convertView.findViewById(R.id.item_root);
                ImageView listIconImageView = (ImageView)convertView.findViewById(R.id.iv_list_icon);
                TextView titleTextView = (TextView)convertView.findViewById(R.id.tv_title);
                TextView descTextView = (TextView)convertView.findViewById(R.id.tv_desc);
                AoaItemInfo item = getItem(position);
                if (item.isListItem()) {
                    listIconImageView.setVisibility(View.VISIBLE);
                } else {
                    listIconImageView.setVisibility(View.GONE);
                }
                titleTextView.setText(item.getTitle());
                descTextView.setText(item.getDescription());
                return convertView;
            }
        };
        listAdapter.addAll(list);
        return listAdapter;
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        AoaItemInfo item = (AoaItemInfo)listView.getItemAtPosition(position);
        Intent intent = new Intent(this, item.getClazz());
        startActivity(intent);
    }
}
