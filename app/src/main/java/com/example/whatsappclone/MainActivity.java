package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.whatsappclone.LogInSignUp.LogInActivity;
import com.example.whatsappclone.helper.TabAccesorAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager mainViewPager;
    TabLayout tabLayout;
    TabAccesorAdapter tabAccesorAdapter;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference();
        toolbar = findViewById(R.id.main_activity_toolbar);
        mainViewPager = findViewById(R.id.main_tab_viewPager);
        tabLayout = findViewById(R.id.main_tabs);
        tabAccesorAdapter = new TabAccesorAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(tabAccesorAdapter);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(mainViewPager);
        getSupportActionBar().setTitle("Whatsapp");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=auth.getCurrentUser();
        if (currentUser==null)
        {

            SendUserToLogInActivity();

        }

    }

    private void SendUserToLogInActivity() {
        Intent intent =new Intent(MainActivity.this, LogInActivity.class);
        startActivity(intent);
    }
}