package com.example.nathaniel.cs449_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    //Setting Spinners
    Spinner start_weight_volume_spin = (Spinner) findViewById(R.id.starting_val_spinner);
    Spinner result_weight_volume_spin = (Spinner) findViewById(R.id.result_val_spinner);

    //Setting Spinner boolean values
    boolean start_tsp = false, result_tsp = false, start_tbsp = false, result_tbsp = false,
        start_oz = false, result_oz = false, start_cup = false, result_cup = false,
        start_lbs = false, result_lbs = false, start_pint = false, result_pint = false,
        start_quart = false, result_quart = false, start_gallon = false, result_gallon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting Toolbar
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);

        //ArrayAdapter using string array and spinner layout
        ArrayAdapter<CharSequence> start_adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_volume_units, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> result_adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_volume_units, android.R.layout.simple_spinner_dropdown_item);

        //Specifying layout
        start_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        result_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Applying Adapter
        start_weight_volume_spin.setAdapter(start_adapter);
        start_weight_volume_spin.setOnItemSelectedListener(this);
        result_weight_volume_spin.setAdapter(result_adapter);
        result_weight_volume_spin.setOnItemSelectedListener(this);
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
        Intent intent;
        switch (item.getItemId()) {
            case R.id.temp_button:
                // User chose the "Temp Menu" item, show other conversion menu...
               Intent temp_intent = new Intent(this, TempActivity.class);
                startActivity(temp_intent);
                return true;

            case R.id.about_button:
                // User chose the "About" item, show about info...
                intent = new Intent(this, AboutActivity.class);
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
        // An item was selected. Retrieve the selected item using
        // parent.getItemAtPosition(pos)
        // Identical switch cases are simply for proof of concept.
        TextView result_string;

        // Switch case determining which spinner was clicked
        switch (parent.getId()) {
            case R.id.starting_val_spinner:

                // Switch case for which option of that spinner was clicked
                switch (pos) {
                    case 0: // first option in spinner
                        start_tsp = true;
                        break;
                    case 1: // second option in spinner
                        start_tbsp = true;
                        break;
                    case 2: // third option in spinner
                        start_oz = true;
                        break;
                    case 3:
                        start_lbs = true;
                        break;
                    case 4:
                        start_cup = true;
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

            // Result Spinner clicked
            case R.id.result_val_spinner:

                // Switch case for which option of that spinner was clicked
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


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}



