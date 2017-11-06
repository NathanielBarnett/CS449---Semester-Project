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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.id.content;
import static com.example.nathaniel.cs449_app.R.id.textView;

/**
 * Created by Nathaniel on 9/24/2017.
 */

public class TempActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Temp Bools
    // If start_temp == true, then start temp is fahrenheit, if false, then start_temp is celsius
    // same for result_temp
    boolean start_temp = false, result_temp = false;

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
        Spinner start_temp_spin = (Spinner) findViewById(R.id.starting_temp_spinner);
        Spinner result_temp_spin = (Spinner) findViewById(R.id.result_temp_spinner);

        //ArrayAdapter using string array and spinner layout
        ArrayAdapter<CharSequence> start_temp_adapter = ArrayAdapter.createFromResource(this,
                R.array.temp_units, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> result_temp_adapter = ArrayAdapter.createFromResource(this,
                R.array.temp_units, android.R.layout.simple_spinner_dropdown_item);

        //Specifying layout
        start_temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        result_temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Applying Adapter
        start_temp_spin.setAdapter(start_temp_adapter);
        start_temp_spin.setOnItemSelectedListener(this);
        result_temp_spin.setAdapter(result_temp_adapter);
        result_temp_spin.setOnItemSelectedListener(this);

        //Setting result view
        TextView result_textView = (TextView) findViewById(R.id.result_temp_view);
        SpannableString new_result = new SpannableString("Result Value");
        new_result.setSpan(new UnderlineSpan(), 0, new_result.length(), 0);
        result_textView.setText(new_result);

        //Setting convert button
        Button mTempConvertButton = (Button) findViewById(R.id.temp_convert_button);

        mTempConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double input_Val = 0.0, converted_val;
                int choice;
                EditText start_string = (EditText) findViewById(R.id.starting_val_temp);
                TextView result_view = (TextView) findViewById(R.id.result_temp_view);

                // Set up flags for starting ending units
                if (start_temp) {
                    choice = 0;
                }
                else {
                    choice = 1;
                }

                //if starting ending units are different, then use choice variable.
                // else starting/ending units are same, and display input value.
                if (result_temp != start_temp) {
                    try {
                        input_Val = Double.parseDouble(start_string.getText().toString());
                    } catch (NumberFormatException exc) {
                        result_view.setText(String.valueOf(0));
                    }

                    converted_val = temp_converter_wrapper(choice, input_Val);
                    result_view.setText(String.valueOf(converted_val));
                }
                else {
                    result_view.setText(String.valueOf(input_Val));
                }
            }
        });


    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. Retrieve the selected item using
        // parent.getItemAtPosition(pos)
        // Identical switch cases are simply for proof of concept.
        TextView result_string;
        switch (parent.getId()) {
            case R.id.starting_temp_spinner:
                switch (pos) {
                    case 0: // first option in spinner
                        start_temp = true;
                        result_string = (TextView) findViewById(R.id.result_val_view);
//                  result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                        break;
                    case 1: // second option in spinner
                        start_temp = false;
                        result_string = (TextView) findViewById(R.id.result_val_view);
//                  result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                        break;
                    default:
                        break;
                }
            case R.id.result_temp_spinner:
                switch (pos) {
                    case 0: // first option in spinner
                        result_temp = true;
                        result_string = (TextView) findViewById(R.id.result_val_view);
//                  result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                        break;
                    case 1: // second option in spinner
                        result_temp = false;
                        result_string = (TextView) findViewById(R.id.result_val_view);
//                  result_string.setText(String.valueOf(parent.getItemAtPosition(pos)));
                        break;
                    default:
                        break;
                }

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    //Param: choice -> 0 = fahrenheit to celsius, else =  celsius to fahrenheit
    private double temp_converter_wrapper (int choice, double input_temp){
        if (choice == 0) {
           return TempConverter.fah_To_cel(input_temp);
        }
        else {
            return TempConverter.cel_To_fah(input_temp);
        }
    }
}

