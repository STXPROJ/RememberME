package com.example.user.remember_me;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class EditSessionActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //do some stuff for example write on log and update TextField on activity
        Log.w("DatePicker","Date = " + year);
        ((TextView) findViewById(R.id.txt_Hora_inicial)).setText("Date = " + year);
    }}