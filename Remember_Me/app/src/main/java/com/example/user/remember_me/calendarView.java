package com.example.user.remember_me;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class calendarView extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    DatePicker selector;
    Button ok;
    TextView paVer;
    DatePicker picker;
    TextView txt_fecha;
    ImageButton btnAtras;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);


        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c =Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String formato = DateFormat.getDateInstance().format(c.getTime());
        TextView verFecha = (TextView) findViewById(R.id.paVer);
        verFecha.setText(formato);

    }

 public void Atras(View v){
     @SuppressLint("WrongViewCast") ImageButton btnAtras = (ImageButton) findViewById(R.id.btnAtras);
     btnAtras.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(String.valueOf(Nueva_Tarea_Fragment.class));
             startActivity(intent);
         }
     });
}}