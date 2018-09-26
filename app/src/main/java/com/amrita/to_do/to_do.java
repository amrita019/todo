package com.amrita.to_do;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class to_do extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton mtdfab;
    ArrayList<ListModel> listModel;
    EditText txtDate;
    EditText txtTime;
    LinearLayout toDoEnterDateLinearLayout;
    public Context context;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        toDoEnterDateLinearLayout = (LinearLayout) findViewById(R.id.toDoEnterDateLinearLayout);
        mtdfab = (FloatingActionButton) findViewById(R.id.makeToDoFloatingActionButton);
        final EditText editText= (EditText)findViewById(R.id.userToDoEditText);

        Switch reminderSwitch = (Switch) findViewById(R.id.toDoHasDateSwitchCompat);
        reminderSwitch.setChecked(true);
        reminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    toDoEnterDateLinearLayout.setVisibility(View.GONE);
                }
                else {
                    toDoEnterDateLinearLayout.setVisibility(View.VISIBLE);
                }
            }
        });



        mtdfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().toString() != null)
                {
                    String toDoTitle = editText.getText().toString();
                    String date = txtDate.getText().toString();
                    String time=txtTime.getText().toString();

                    listModel = ListModel.addElement(toDoTitle,date,time, getApplicationContext());
                    Intent i = new Intent(to_do.this,MainActivity.class);
                    startActivity(i);


                }
                else
                    {
                    Toast.makeText(null, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });


        txtDate =(EditText)findViewById(R.id.newTodoDateEditText);
        txtTime =(EditText)findViewById(R.id.newTodoTimeEditText);

        txtDate.setOnClickListener(this);
        txtTime.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == txtDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == txtTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }



    }

