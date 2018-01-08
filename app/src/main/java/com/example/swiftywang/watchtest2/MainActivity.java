package com.example.swiftywang.watchtest2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wear.widget.drawer.WearableActionDrawerView;
import android.support.wear.widget.drawer.WearableDrawerLayout;
import android.support.wear.widget.drawer.WearableNavigationDrawerView;
import android.support.wearable.activity.WearableActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends WearableActivity implements MenuItem.OnMenuItemClickListener {

    private TextView mTextView;
    private WearableDrawerLayout mWearableDrawerLayout;
    private WearableNavigationDrawerView mWearableNavigationDrawer;
    private WearableActionDrawerView mWearableActionDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
        // Top navigation drawer
        mWearableNavigationDrawer = (WearableNavigationDrawerView) findViewById(R.id.top_navigation_drawer);
        mWearableNavigationDrawer.setAdapter(new YourImplementationNavigationAdapter(this));
        // Peeks navigation drawer on the top.
        mWearableNavigationDrawer.getController().peekDrawer();
        // Bottom action drawer
        mWearableActionDrawer = (WearableActionDrawerView) findViewById(R.id.bottom_action_drawer);
        // Peeks action drawer on the bottom.
        mWearableActionDrawer.getController().peekDrawer();
        mWearableActionDrawer.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    private class YourImplementationNavigationAdapter extends WearableNavigationDrawerView.WearableNavigationDrawerAdapter {
        public YourImplementationNavigationAdapter(Context context) {
        }

        @Override
        public CharSequence getItemText(int pos) {
            return "action " + pos;
        }

        @Override
        public Drawable getItemDrawable(int pos) {
            return getDrawable(R.mipmap.ic_launcher);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
