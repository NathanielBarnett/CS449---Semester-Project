package com.example.nathaniel.cs449_app;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting Toolbar
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);

        //Setting Spinners
        Spinner weight_volume_spin = (Spinner) findViewById(R.id.starting_val_spinner);

        //ArrayAdapter using string array and spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_volume_units, android.R.layout.simple_spinner_dropdown_item);

        //Specifying layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Applying Adapter
        weight_volume_spin.setAdapter(adapter);
        weight_volume_spin.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_button:
                // User chose the "Menu" item, show other conversion menu...
                return true;

            case R.id.about_button:
                // User chose the "About" item, show about info...
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        TextView result_string;
        switch (pos) {
            case 0: // first option in spinner
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 1: // second option in spinner
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 2: // third option in spinner
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 3:
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 4:
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 5:
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 6:
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            case 7:
                result_string = (TextView) findViewById(R.id.result_val_view);
                result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}



