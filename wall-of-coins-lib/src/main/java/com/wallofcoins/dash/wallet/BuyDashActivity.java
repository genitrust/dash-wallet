package com.wallofcoins.dash.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class BuyDashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_dash_content);
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
