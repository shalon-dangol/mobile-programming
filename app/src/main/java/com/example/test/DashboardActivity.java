package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewpager;
    private Toolbar toolbar;
    private int[] iconList = {R.drawable.ic_house, R.drawable.ic_search, R.drawable.ic_user};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initToolbar();
        findViews();
        setupViewpager();
        tabLayout.setupWithViewPager(viewpager);
        setIcon();
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Dashboard");
    }


    private void findViews(){
        tabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewpager);
    }

    private void setIcon(){
        tabLayout.getTabAt(0).setIcon(iconList[0]);
        tabLayout.getTabAt(1).setIcon(iconList[1]);
        tabLayout.getTabAt(2).setIcon(iconList[2]);
    }

    private void setupViewpager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new MessageFragment(), "Message");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewpager.setAdapter(adapter);
    }

}