package com.example.weremindyou;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedPriority;
    EditText editText_Name;
    boolean isEnabled ;
    String name;
    Calendar calendar;
    Button dateButton;
    Button timeButton;
    Button btn_done;
    int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
        gettingValuesFromViews();

    }

    // In this method priority of the remainder i.e high,medium,low is set and also
    //used toast to display a message if nothing selected.
    // In this the date and time buttons are also created
    private void gettingValuesFromViews() {

        radioGroup.getCheckedRadioButtonId();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar=Calendar.getInstance();
                mHour = calendar.get(Calendar.HOUR_OF_DAY);
                mMinute = calendar.get(Calendar.MINUTE);
            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText_Name.getText().toString();
                isEnabled = ((CheckBox) findViewById(R.id.enabled)).isChecked();
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectedPriority = findViewById(selectedRadioButtonId);
                    String selectedRbText = selectedPriority.getText().toString();
                    Toast.makeText(EditActivity.this, "Title: "+name+"\nEnabled: "+isEnabled +"\nPriority: "+selectedRbText, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EditActivity.this, "Nothing selected from the radio group", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        editText_Name = findViewById(R.id.name);
        radioGroup = findViewById(R.id.radiobutton_priority);
        btn_done = findViewById(R.id.done);
    }

    public void onCancelClick(View view)
    {
        setResult(RESULT_CANCELED, null);
        finish();
    }
    public void onDoneClick(View v)
    {
        Intent in = new Intent(this,MainActivity.class);
//        setResult(RESULT_OK,in);

        startActivity(in);
      //  setContentView(R.layout.fragment_tasks);
//        finish();
    }




}
