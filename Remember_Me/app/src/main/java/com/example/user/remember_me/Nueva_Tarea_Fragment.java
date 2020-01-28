package com.example.user.remember_me;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
<<<<<<< HEAD
import android.app.TimePickerDialog;
=======
import android.app.Dialog;
>>>>>>> 9b48d6df08b0018875e19d442ab3ebdda5acb2e3
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorRecurrence;
import com.example.user.remember_me.Coordinador.CoordinadorTask;
import com.example.user.remember_me.Logica.LogicaRecurrence;
import com.example.user.remember_me.Logica.LogicaTask;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;
import com.example.user.remember_me.ModeloVO.TaskVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
=======
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.YEAR;
>>>>>>> 9b48d6df08b0018875e19d442ab3ebdda5acb2e3


@RequiresApi(api = Build.VERSION_CODES.N)
public class Nueva_Tarea_Fragment extends Fragment {

    private Spinner mnt_spinner;
    private Spinner mest_spinner;
    private EditText mtxtNombreTarea;
    private EditText mtxtNota;
    private TextView view_fecha;
    private Button mbtnSave;
    private LinearLayout mHorainicial;
    private LinearLayout mHoraFinal;
    private Switch mswitchDia;
    private ImageButton btnFecha;
    private ImageButton btnHoraIncio;
    private ImageButton btnHoraFinal;
    private Calendar mCalendar = Calendar.getInstance(TimeZone.getDefault());
    private TextView mviewFecha;
    private TextView mtxtHoraInicio;
    private TextView mtxtHoraFinal;

    private CoordinadorTask mcoordTask;
    private LogicaTask mlogicaTask;
    private TaskVO mtask;
    private ArrayList<RecurrenceVO> mlistaRecurrence;
    private CoordinadorRecurrence mcoordRecurrence;
    private LogicaRecurrence mlogicaRecurrence;
    private RecurrenceVO mrecurrence;
    private BaseDeDatos mDb;
    private ArrayList<TaskVO> mlistaTask;

    private int day, month,year;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_nueva__tarea_, container, false);

        mtxtNombreTarea = (EditText) view.findViewById(R.id.nom_tarea);
        mtxtNota = (EditText) view.findViewById(R.id.txt_nota);
        mbtnSave = view.findViewById(R.id.btn_guardar);
        mHoraFinal = (LinearLayout) view.findViewById(R.id.horafinal);
        mHorainicial = (LinearLayout) view.findViewById(R.id.horainicial);
        mswitchDia = (Switch) view.findViewById(R.id.switch2);
        mviewFecha = (TextView)view.findViewById(R.id.view_fecha);
        btnFecha = (ImageButton) view.findViewById(R.id.btnFecha);
        btnHoraIncio = (ImageButton) view.findViewById(R.id.btnHoraInicial);
        btnHoraFinal = (ImageButton) view.findViewById(R.id.btnHoraFinal);
        mtxtHoraInicio = (TextView) view.findViewById(R.id.view_hora_inicial);
        mtxtHoraFinal = (TextView) view.findViewById(R.id.view_hora_final);
        mswitchDia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    mHoraFinal.setVisibility(View.INVISIBLE);
                    mHorainicial.setVisibility(View.INVISIBLE);
                }else{
                    mHoraFinal.setVisibility(View.VISIBLE);
                    mHorainicial.setVisibility(View.VISIBLE);

                }
            }
        });

        // Set Logica y Coordinador de Task
        mcoordTask = new CoordinadorTask();
        mlogicaTask = new LogicaTask();
        mcoordTask.setLogica(mlogicaTask);
        mlogicaTask.setCoordinador(mcoordTask);
        // Set Logica y Coordinador de Recurrence
        mcoordRecurrence = new CoordinadorRecurrence();
        mlogicaRecurrence = new LogicaRecurrence();
        mlogicaRecurrence.setCoordinador(mcoordRecurrence);
        mcoordRecurrence.setLogica(mlogicaRecurrence);
        //Abrir base de Datos
        mDb = new BaseDeDatos(getContext());


        mlistaRecurrence = mcoordRecurrence.listaRecurrence();
        ArrayList<String> frecuencia = new ArrayList<String>();
        for(int i=0;i<mlistaRecurrence.size();i++){
            frecuencia.add(mlistaRecurrence.get(i).getname());
        }
        // Llenar el spinner de frecuencia con la clase Recurrence
        mnt_spinner = (Spinner) view.findViewById(R.id.nt_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,frecuencia );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mnt_spinner.setAdapter(arrayAdapter);

        //Llenando el est_spinner del array en el archivo strings
        String[] estandar;
        mest_spinner = (Spinner) view.findViewById(R.id.est_spinner);
        estandar = getResources().getStringArray(R.array.est_spinner_array);
        ArrayAdapter<String> array_Adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, estandar);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mest_spinner.setAdapter(array_Adapter);
    mbtnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mtask = new TaskVO();
            mrecurrence = mcoordRecurrence.buscarRecurrence((int) mnt_spinner.getSelectedItemId() + 1);
            mtask.setname(mtxtNombreTarea.getText().toString());
            mtask.setdescription(mtxtNota.getText().toString());
            mtask.setRecurrence(mrecurrence);
            mtask.settaskDate(mviewFecha.getText().toString());
            mtask.setstartTime(mtxtHoraInicio.getText().toString());
            mtask.setendTime(mtxtHoraFinal.getText().toString());
            Toast.makeText(getActivity(), "Tarea Registrada con Exitos", Toast.LENGTH_LONG);
            mcoordTask.addTask(mtask, getContext());
            mtxtNombreTarea.setText("");
            mtxtNota.setText("");}});

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR,year);
            mCalendar.set(Calendar.MONTH,monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            getDate();
        }
<<<<<<< HEAD
    };

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(),date,mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
       final TimePickerDialog.OnTimeSetListener timeStart =  new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                mCalendar.set(Calendar.MINUTE, minute);
                getTime(1);
            }};
        final TimePickerDialog.OnTimeSetListener timeEnd =  new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                mCalendar.set(Calendar.MINUTE, minute);
                getTime(2);
            }};

        btnHoraIncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(getContext(),timeStart,mCalendar.get(Calendar.HOUR_OF_DAY),
                        mCalendar.get(Calendar.MINUTE),false).show();

            }});
        btnHoraFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(getContext(),timeEnd,mCalendar.get(Calendar.HOUR_OF_DAY),
                        mCalendar.get(Calendar.MINUTE),false).show();

            }
        });
return view;
    }
    private void getDate(){

        SimpleDateFormat formato = new SimpleDateFormat("dd/M/yy");
        mviewFecha.setText(formato.format(mCalendar.getTime()));
    }
    private void getTime(int type){
        SimpleDateFormat format = new SimpleDateFormat("H/m/a");
        switch (type){

            case 1:
                mtxtHoraInicio.setText(format.format(mCalendar.getTime()));
                break;
                case 2:
                    mtxtHoraFinal.setText(format.format(mCalendar.getTime()));
                    break;
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
=======
    });

>>>>>>> 9b48d6df08b0018875e19d442ab3ebdda5acb2e3


return view;
    }



    }





