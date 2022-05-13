package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.whatsappclone.helper.TabAccesorAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager mainViewPager;
    TabLayout tabLayout;
    TabAccesorAdapter tabAccesorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_activity_toolbar);
        mainViewPager = findViewById(R.id.main_tab_viewPager);
        tabLayout = findViewById(R.id.main_tabs);
        tabAccesorAdapter = new TabAccesorAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(tabAccesorAdapter);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(mainViewPager);
        getSupportActionBar().setTitle("Whatsapp");
    }
}