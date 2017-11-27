package com.example.nathaniel.cs449_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Nathaniel on 9/23/2017.
 */

public class AboutActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        Toolbar aboutToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(aboutToolbar);

        // get a support action bar corresponding to this toolbar
        ActionBar about_bar = getSupportActionBar();

        // Enable "up" functionality
        about_bar.setDisplayHomeAsUpEnabled(true);

        // get intent from previous activity...
        Intent intent = getIntent();
        }


        }
