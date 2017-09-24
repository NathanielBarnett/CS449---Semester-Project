package com.example.nathaniel.cs449_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Nathaniel on 9/24/2017.
 */

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_activity);

        Toolbar tempToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tempToolbar);

        // get a support action bar corresponding to this toolbar
        ActionBar temp_bar = getSupportActionBar();

        // Enable "up" functionality
        temp_bar.setDisplayHomeAsUpEnabled(true);

        // get intent from previous activity...
        Intent intent = getIntent();
    }
}
