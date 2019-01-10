package com.example.amikom.simplenewsapps.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.amikom.simplenewsapps.adapter.ViewPagerAdapter;
import com.example.amikom.simplenewsapps.R;
import com.example.amikom.simplenewsapps.fragment.BusinessFragment;
import com.example.amikom.simplenewsapps.fragment.EntertainmentFragment;
import com.example.amikom.simplenewsapps.fragment.HealthFragment;
import com.example.amikom.simplenewsapps.fragment.ScienceFragment;
import com.example.amikom.simplenewsapps.fragment.SportFragment;
import com.example.amikom.simplenewsapps.fragment.TechnologyFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_title);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTab();
    }

    private void setupTab() {
        TextView scienceTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        scienceTab.setText(getText(R.string.tv_sc));
        tabLayout.getTabAt(0).setCustomView(scienceTab);

        TextView technologyTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        technologyTab.setText(getText(R.string.tv_Tc));
        tabLayout.getTabAt(1).setCustomView(technologyTab);

        TextView businessTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        businessTab.setText(getText(R.string.tv_Bs));
        tabLayout.getTabAt(2).setCustomView(businessTab);

        TextView entertainmentTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        entertainmentTab.setText(getText(R.string.tv_En));
        tabLayout.getTabAt(3).setCustomView(entertainmentTab);

        TextView sportTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        sportTab.setText(getText(R.string.tv_sp));
        tabLayout.getTabAt(4).setCustomView(sportTab);

        TextView healthTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        healthTab.setText(getText(R.string.tv_hl));
        tabLayout.getTabAt(5).setCustomView(healthTab);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScienceFragment(), "Science");
        adapter.addFragment(new TechnologyFragment(), "Technology");
        adapter.addFragment(new BusinessFragment(), "Business");
        adapter.addFragment(new EntertainmentFragment(), "Entertainment");
        adapter.addFragment(new SportFragment(), "Sport");
        adapter.addFragment(new HealthFragment(), "Health");
        viewPager.setAdapter(adapter);
    }

    @Override
    // Initialize the contents of the Activity's options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    // This method is called whenever an item in the options menu is selected.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
