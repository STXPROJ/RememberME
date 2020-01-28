package com.example.user.remember_me.Logica;

import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;


import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorRecurrence;
import com.example.user.remember_me.ModeloDAO.RecurrenceDAO;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;

import java.util.ArrayList;

public class LogicaRecurrence {
    private CoordinadorRecurrence mcoordRecurrence;
    private RecurrenceVO mRecurrence;
    private ArrayList<RecurrenceVO> mListaRecurrence;
    public  void setCoordinador(CoordinadorRecurrence coordRecurrence){
        this.mcoordRecurrence = coordRecurrence;
    }

    public void validarAddRecurrence(RecurrenceVO recurrence) {
        boolean isSaved = BaseDeDatos.mRecurrenceDAO.addRecurrence(recurrence);
        if (isSaved == true) {
            Log.d("Database", "Registro de la tabla Recurrence Anadido");
        }
    }


    public ArrayList<RecurrenceVO> validarListRecurrence() {
        mListaRecurrence = BaseDeDatos.mRecurrenceDAO.fetchAllRecurrence();
        if (mListaRecurrence != null) {
            Log.d("Database", "Lista Recurrence creada");
            return mListaRecurrence;
        } else {
            Log.d("Database", "No hay registros en la tabla Recurrence");
            return null;
        }
    }
    public RecurrenceVO validarBuscarRecurrence(int id) {
        mRecurrence = BaseDeDatos.mRecurrenceDAO.fetchById(id);
        if (mRecurrence != null) {
            Log.d("Database","Se encontro el registro "+ id+ " en la tabla Recurrence");
            return mRecurrence;
        } else {
            Log.d("Database","No se encontro el registro " + id + " en la tabla Recurrence");
            return null;
        }
    }
    public void validarDeleteRecurrence(int id){
        int isDeleted = BaseDeDatos.mRecurrenceDAO.deleteRecurrence(id);
        if(isDeleted != 0) {
            Log.d("Database", "Se elimiaron " + id + " registros de la tabla Recurrence");
        }else {
            Log.d("Database","No se encontraron registros en la tabla Recurrence " );
        }
    }
}
