package com.example.user.remember_me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.remember_me.Coordinador.CoordinadorTask;
import com.example.user.remember_me.Logica.LogicaTask;
import com.example.user.remember_me.ModeloVO.TaskVO;

import java.util.ArrayList;
import java.util.List;

public class elementos_prox_tareas extends AppCompatActivity {
    private ListView mlistview;
    private ArrayList<TaskVO> mlistaTarea;
    private CoordinadorTask mcoordTask;
    private LogicaTask mlogicaTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos_prox_tareas);
        int preSelectedIndex = -1;

        // Declarar Logica y Coordinador
        mlogicaTask = new LogicaTask();
        mcoordTask = new CoordinadorTask();
        mlogicaTask.setCoordinador(mcoordTask);
        mcoordTask.setLogica(mlogicaTask);



        mlistaTarea = mcoordTask.getNextTask();
            ListView listView = (ListView) findViewById(R.id.el_proximastareas);


            final List<TaskVO> tasks = new ArrayList<>();
            for(int i= 0;i<mlistaTarea.size();i++) {
                tasks.add(new TaskVO(mlistaTarea.get(i).getidTask(),mlistaTarea.get(i).getname(),
                        mlistaTarea.get(i).gettaskDate(),mlistaTarea.get(i).getisDone()));

            }
            final CustomAdapter adapter = new CustomAdapter(this, tasks);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    TaskVO model = tasks.get(i);

                    if (model.getisDone())
                        model.setisDone(false);

                    else
                        model.setisDone(true);

                    tasks.set(i, model);

                    //now update adapter
                    adapter.updateRecords(tasks);
                }
            });

        }
    }
