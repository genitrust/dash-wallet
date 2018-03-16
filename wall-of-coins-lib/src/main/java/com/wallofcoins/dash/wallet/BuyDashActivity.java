package com.wallofcoins.dash.wallet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class BuyDashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_dash_content);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbarView = (Toolbar) findViewById(R.id.toolbar);
        if (toolbarView != null) {
            setSupportActionBar(toolbarView);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        BuyDashFragment fr = (BuyDashFragment) getSupportFragmentManager().findFragmentById(R.id.buy_dash_fragment);

        if (fr.hideViewManageBack()) {
            super.onBackPressed();
        }
    }
}
