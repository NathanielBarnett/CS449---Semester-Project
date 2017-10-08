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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Setting Spinner boolean values
    //Starting spinner values
    boolean start_tsp = false, start_tbsp = false, start_oz = false, start_cup = false,
            start_lbs = false, start_pint = false, start_quart = false, start_gallon = false,
    //Result spinner values
            result_tsp = false, result_tbsp = false, result_oz = false,  result_cup = false,
            result_lbs = false,  result_pint = false, result_quart = false,  result_gallon = false;

    //Setting convert buttons
    Button mConvertButton, mPrevConvertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting Spinners
        Spinner start_weight_volume_spin = (Spinner) findViewById(R.id.starting_val_spinner);
        Spinner result_weight_volume_spin = (Spinner) findViewById(R.id.result_val_spinner);

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

        //assigning Buttons
        mConvertButton = (Button) findViewById(R.id.convert_button);
        mPrevConvertButton = (Button) findViewById(R.id.prev_convert_button);
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
        TextView result_string, start_string;


        result_string = (TextView) findViewById(R.id.result_val_test);
        start_string = (TextView) findViewById(R.id.start_val_test);
        // Switch case determining which spinner was clicked
        switch (parent.getId()) {
            case R.id.starting_val_spinner:

                // Switch case for which option of that spinner was clicked
                switch (pos) {
                    case 0: // first option in spinner
                        reset_bools("start");
                        start_tsp = true;
                        start_string.setText(String.valueOf(start_tsp));
                        break;
                    case 1: // second option in spinner
                        reset_bools("start");
                        start_tbsp = true;
                        start_string.setText(String.valueOf(start_tbsp));
                        break;
                    case 2: // third option in spinner
                        reset_bools("start");
                        start_oz = true;
                        start_string.setText(String.valueOf(start_oz));
                        break;
                    case 3:
                        reset_bools("start");
                        start_lbs = true;
                        start_string.setText(String.valueOf(start_lbs));
                        break;
                    case 4:
                        reset_bools("start");
                        start_cup = true;
                        start_string.setText(String.valueOf(start_cup));
                        break;
                    case 5:
                        reset_bools("start");
                        start_pint = true;
                        start_string.setText(String.valueOf(start_pint));
                        break;
                    case 6:
                        reset_bools("start");
                        start_quart = true;
                        start_string.setText(String.valueOf(start_quart));
                        break;
                    case 7:
                        reset_bools("start");
                        start_gallon = true;
                        start_string.setText(String.valueOf(start_gallon));
                        break;
                    default:
                        break;
                }

            // Result Spinner clicked
            case R.id.result_val_spinner:

                // Switch case for which option of that spinner was clicked
                switch (pos) {
                    case 0: // first option in spinner
                        reset_bools("result");
                        result_tsp = true;
                        result_string.setText(String.valueOf(result_tsp));
                        break;
                    case 1: // second option in spinner
                        reset_bools("result");
                        result_tbsp = true;
                        result_string.setText(String.valueOf(result_tbsp));
                        break;
                    case 2: // third option in spinner
                        reset_bools("result");
                        result_oz = true;
                        result_string.setText(String.valueOf(result_oz));
                        break;
                    case 3:
                        reset_bools("result");
                        result_lbs = true;
                        result_string.setText(String.valueOf(result_lbs));
                        break;
                    case 4:
                        reset_bools("result");
                        result_cup = true;
                        result_string.setText(String.valueOf(result_cup));
                    case 5:
                        reset_bools("result");
                        result_pint = true;
                        result_string.setText(String.valueOf(result_pint));
                        break;
                    case 6:
                        reset_bools("result");
                        result_quart = true;
                        result_string.setText(String.valueOf(result_quart));
                        break;
                    case 7:
                        reset_bools("result");
                        result_gallon = true;
                        result_string.setText(String.valueOf(result_gallon));
                        break;
                    default:
                        break;
                }

        }


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    //Param: String "start" or "result"
    //Post: Starting spinner boolean or result spinner boolean values are set to false
    private void reset_bools(String start_result) {
        //Reset starting spinner values to false
        if (start_result == "start") {
            start_tsp = false; start_tbsp = false; start_oz = false; start_cup = false;
            start_lbs = false; start_pint = false; start_quart = false; start_gallon = false;

        }
        //Reset result spinner values to false
        else if (start_result == "result") {
            result_tsp = false; result_tbsp = false; result_oz = false;  result_cup = false;
            result_lbs = false;  result_pint = false; result_quart = false;  result_gallon = false;
        }
        //If incorrect input given -> throw exception
        else {

        }

    }
}



