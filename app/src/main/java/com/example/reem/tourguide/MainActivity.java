package com.example.reem.tourguide;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import activities.HospitalsActivity;
import activities.HostelsActivity;
import activities.HotelsActivity;
import activities.LandmarksActivity;
import activities.RestaurantsActivity;
import activities.ShoppingPlacesActivity;
import activities.TemplesActivity;
import activities.TransportsActivity;


public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // Changing the statusbar color
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.nav_temples:
                                Intent intent = new Intent(MainActivity.this, TemplesActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_landmarks:
                                intent = new Intent(MainActivity.this, LandmarksActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_hotels:
                                intent = new Intent(MainActivity.this, HotelsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_hostels:
                                intent = new Intent(MainActivity.this, HostelsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_restaurants:
                                intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_shopping:
                                intent = new Intent(MainActivity.this, ShoppingPlacesActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_htrasports:
                                intent = new Intent(MainActivity.this, TransportsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_hospitals:
                                intent = new Intent(MainActivity.this, HospitalsActivity.class);
                                startActivity(intent);
                                break;
                            default:
                                break;

                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
