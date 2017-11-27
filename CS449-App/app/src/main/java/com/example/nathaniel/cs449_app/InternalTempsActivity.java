package com.example.nathaniel.cs449_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Nathaniel on 11/26/2017.
 */

public class InternalTempsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_temps);
        Toolbar internalTempToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(internalTempToolbar);

        // get a support action bar corresponding to this toolbar
        ActionBar internal_temp_bar = getSupportActionBar();

        // Enable "up" functionality
        internal_temp_bar.setDisplayHomeAsUpEnabled(true);

        // get intent from previous activity...
        Intent intent = getIntent();
    }


}