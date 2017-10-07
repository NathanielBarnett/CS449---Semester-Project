package com.example.nathaniel.cs449_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.id.content;
import static com.example.nathaniel.cs449_app.R.id.textView;

/**
 * Created by Nathaniel on 9/24/2017.
 */

public class TempActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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

        //Setting Spinners
        Spinner start_temp_spin = (Spinner) findViewById(R.id.starting_val_spinner);
        Spinner result_temp_spin = (Spinner) findViewById(R.id.result_val_spinner);

        //ArrayAdapter using string array and spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temp_units, android.R.layout.simple_spinner_dropdown_item);

        //Specifying layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Applying Adapter
        start_temp_spin.setAdapter(adapter);
        result_temp_spin.setAdapter(adapter);
        start_temp_spin.setOnItemSelectedListener(this);
        result_temp_spin.setOnItemSelectedListener(this);

        //Setting result view
        TextView result_textView = (TextView) findViewById(R.id.result_temp_view);
        SpannableString new_result = new SpannableString("Result Value");
        new_result.setSpan(new UnderlineSpan(), 0, new_result.length(), 0);
        result_textView.setText(new_result);


    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. Retrieve the selected item using
        // parent.getItemAtPosition(pos)
        // Identical switch cases are simply for proof of concept.
        TextView result_string;
        switch (pos) {
            case 0: // first option in spinner
                result_string = (TextView) findViewById(R.id.result_val_view);
//                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 1: // second option in spinner
                result_string = (TextView) findViewById(R.id.result_val_view);
//                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

