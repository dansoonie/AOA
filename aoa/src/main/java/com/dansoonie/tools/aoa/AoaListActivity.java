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

        setListAdapter(createListAdapter());
    }

    private List<AoaItemInfo> createActivityList() {
        List<AoaItemInfo> activityList = new ArrayList<>();

        try {
            PackageManager pkgManager = getPackageManager();
            String pkgName = getPackageName();
            PackageInfo pkgInfo = pkgManager.getPackageInfo(pkgName, PackageManager.GET_ACTIVITIES);
            for (ActivityInfo activityInfo : pkgInfo.activities) {
                // Get AoaItem info
                AoaItem aoa = Class.forName(activityInfo.name).getAnnotation(AoaItem.class);
                // If activity's parent is this list activity class add to list
                if (aoa.parent().equals(this.getClass().getName())) {
                    String name = activityInfo.name;
                    Intent intent = new Intent();
                    intent.setClass(this, Class.forName(name));
                    String title = aoa.title();
                    String description = aoa.description();
                    activityList.add(new AoaItemInfo(intent, title, description));
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

    protected ListAdapter createListAdapter() {
        final ArrayAdapter listAdapter = new ArrayAdapter<AoaItemInfo>(this, android.R.layout.two_line_list_item) {

            private LayoutInflater mInflater;

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    if (mInflater == null) {
                        mInflater = getLayoutInflater();
                    }
                    convertView = mInflater.inflate(android.R.layout.two_line_list_item, parent, false);
                }
                TextView titleTextView = (TextView)convertView.findViewById(android.R.id.text1);
                TextView descTextView = (TextView)convertView.findViewById(android.R.id.text2);
                AoaItemInfo item = getItem(position);
                titleTextView.setText(item.getTitle());
                descTextView.setText(item.getDescription());
                return convertView;
            }
        };
        listAdapter.addAll(createActivityList());
        return listAdapter;
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        AoaItemInfo item = (AoaItemInfo)listView.getItemAtPosition(position);
        Intent intent = item.getIntent();
        startActivity(intent);
    }
}
