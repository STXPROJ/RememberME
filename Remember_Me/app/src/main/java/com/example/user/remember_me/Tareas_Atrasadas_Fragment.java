package com.example.user.remember_me;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.remember_me.Coordinador.CoordinadorTask;
import com.example.user.remember_me.Logica.LogicaTask;
import com.example.user.remember_me.ModeloVO.TaskVO;

import java.util.ArrayList;
import java.util.List;

public class Tareas_Atrasadas_Fragment extends Fragment {
    private ListView mlistview;
    private ArrayList<TaskVO> mlistaTarea;
    private CoordinadorTask mcoordTask;
    private LogicaTask mlogicaTask;
    List<Pair> mPairs = new ArrayList<Pair>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tareas_realizadas_, container, false);
        // Declarar Logica y Coordinador
        mlogicaTask = new LogicaTask();
        mcoordTask = new CoordinadorTask();
        mlogicaTask.setCoordinador(mcoordTask);
        mcoordTask.setLogica(mlogicaTask);

        mlistview = (ListView) view.findViewById(R.id.list_tareas_real);

        mlistaTarea = mcoordTask.getLateTask();
        if (mlistaTarea.isEmpty()) {

         String[] noTask = new String[]{"No hay Tareas Atrasadas","No hay Tareas Atrasadas","No hay Tareas Atrasadas",
                 "No hay Tareas Atrasadas","No hay Tareas Atrasadas","No hay Tareas Atrasadas"};
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                    noTask);
            mlistview.setAdapter(arrayAdapter);
        }else{
        ArrayAdapter<TaskVO> arrayAdapter = new ArrayAdapter<TaskVO>(getActivity(), android.R.layout.simple_list_item_1,
                mlistaTarea);
        mlistview.setAdapter(arrayAdapter);}
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
