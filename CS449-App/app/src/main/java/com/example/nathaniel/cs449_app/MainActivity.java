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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.nathaniel.cs449_app.VConverter;

import static com.example.nathaniel.cs449_app.TempConverter.Round;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Setting Spinner boolean values
    //Starting spinner values
    boolean start_tsp = false, start_tbsp = false, start_oz = false, start_cup = false,
            start_lbs = false, start_pint = false, start_quart = false, start_gallon = false,
    //Result spinner values
            result_tsp = false, result_tbsp = false, result_oz = false,  result_cup = false,
            result_lbs = false,  result_pint = false, result_quart = false,  result_gallon = false;

    //Setting convert buttons
    Button mConvertButton;

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

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double input_Val, converted_val;
               EditText start_string = (EditText) findViewById(R.id.starting_val);
                TextView result_view = (TextView) findViewById(R.id.result_val_view);

                try {
                    input_Val = Double.parseDouble(start_string.getText().toString());
                    converted_val = converter_wrapper(input_Val);
                    result_view.setText(String.valueOf(Round(converted_val, 2)));
                }
                catch (NumberFormatException exc) {
                    result_view.setText(String.valueOf(0));
                }
            }
        });
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

            case R.id.rec_temps_button:
                // User chose the "Rec Internal Temps" button, shows temps...
                intent = new Intent(this, InternalTempsActivity.class);
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

        //result_string = (TextView) findViewById(R.id.result_val_test);
        //start_string = (TextView) findViewById(R.id.start_val_test);
        // Switch case determining which spinner was clicked
        switch (parent.getId()) {
            case R.id.starting_val_spinner:

                // Switch case for which option of that spinner was clicked
                switch (pos) {
                    case 0: // first option in spinner
                        reset_bools("start");
                        start_tsp = true;
                        break;
                    case 1: // second option in spinner
                        reset_bools("start");
                        start_tbsp = true;
                        break;
                    case 2: // third option in spinner
                        reset_bools("start");
                        start_oz = true;
                        break;
                    case 3:
                        reset_bools("start");
                        start_lbs = true;
                        break;
                    case 4:
                        reset_bools("start");
                        start_cup = true;
                        break;
                    case 5:
                        reset_bools("start");
                        start_pint = true;
                        break;
                    case 6:
                        reset_bools("start");
                        start_quart = true;
                        break;
                    case 7:
                        reset_bools("start");
                        start_gallon = true;
                        break;
                    default:
                        break;
                }
                break;

            // Result Spinner clicked
            case R.id.result_val_spinner:

                // Switch case for which option of that spinner was clicked
                switch (pos) {
                    case 0: // first option in spinner
                        reset_bools("result");
                        result_tsp = true;
                        break;
                    case 1: // second option in spinner
                        reset_bools("result");
                        result_tbsp = true;
                        break;
                    case 2: // third option in spinner
                        reset_bools("result");
                        result_oz = true;
                        break;
                    case 3:
                        reset_bools("result");
                        result_lbs = true;
                        break;
                    case 4:
                        reset_bools("result");
                        result_cup = true;
                        break;
                    case 5:
                        reset_bools("result");
                        result_pint = true;
                        break;
                    case 6:
                        reset_bools("result");
                        result_quart = true;
                        break;
                    case 7:
                        reset_bools("result");
                        result_gallon = true;
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

    private double converter_wrapper(double inputVal) {
        boolean[] starting_bools = grab_start_bools(), resulting_bools = grab_result_bools();
        int i = 0, start_bool_loc = 0, result_bool_loc = 0;
        while ( i < 8) {
            if (starting_bools[i]) {
                start_bool_loc = i;
            }
            if (resulting_bools[i]) {
                result_bool_loc = i;
            }
            i = i + 1;
        }
        // if start_bool_loc | result_bool_loc != true, throw exception.

        return conversionSwitchCase(start_bool_loc,result_bool_loc,inputVal);
    }

    private  boolean[] grab_start_bools() {
        boolean[] start_bools = new boolean[8];
        start_bools[0] = start_tsp;
        start_bools[1] = start_tbsp;
        start_bools[2] = start_oz;
        start_bools[3] = start_lbs;
        start_bools[4] = start_cup;
        start_bools[5] = start_pint;
        start_bools[6] = start_quart;
        start_bools[7] = start_gallon;

        return start_bools;
    }

    private  boolean[] grab_result_bools() {
        boolean[] result_bools = new boolean[8];
        result_bools[0] = result_tsp;
        result_bools[1] = result_tbsp;
        result_bools[2] = result_oz;
        result_bools[3] = result_lbs;
        result_bools[4] = result_cup;
        result_bools[5] = result_pint;
        result_bools[6] = result_quart;
        result_bools[7] = result_gallon;

        return result_bools;
    }

    public double conversionSwitchCase(int start_loc, int result_loc, double startVal) {
        double convertedVal = -1;
        // Switch case to catch what starting and ending conversion should be made.
        switch (start_loc) {
            case 0:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.tsp_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.tsp_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.tsp_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.tsp_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.tsp_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.tsp_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.tsp_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.tsp_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.tbsp_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.tbsp_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.tbsp_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.tbsp_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.tbsp_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.tbsp_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.tbsp_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.tbsp_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.oz_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.oz_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.oz_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.oz_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.oz_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.oz_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.oz_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.oz_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.lbs_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.lbs_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.lbs_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.lbs_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.lbs_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.lbs_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.lbs_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.lbs_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.cup_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.cup_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.cup_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.cup_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.cup_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.cup_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.cup_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.cup_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.pint_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.pint_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.pint_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.pint_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.pint_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.pint_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.pint_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.pint_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 6:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.quart_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.quart_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.quart_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.quart_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.quart_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.quart_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.quart_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.quart_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            case 7:
                switch (result_loc) {
                    case 0:
                        convertedVal = VConverter.gallon_To_tsp(startVal);
                        break;
                    case 1:
                        convertedVal = VConverter.gallon_To_tbsp(startVal);
                        break;
                    case 2:
                        convertedVal = VConverter.gallon_To_oz(startVal);
                        break;
                    case 3:
                        convertedVal = VConverter.gallon_To_lbs(startVal);
                        break;
                    case 4:
                        convertedVal = VConverter.gallon_To_cup(startVal);
                        break;
                    case 5:
                        convertedVal = VConverter.gallon_To_pint(startVal);
                        break;
                    case 6:
                        convertedVal = VConverter.gallon_To_quart(startVal);
                        break;
                    case 7:
                        convertedVal = VConverter.gallon_To_gallon(startVal);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return convertedVal;
    }
}





