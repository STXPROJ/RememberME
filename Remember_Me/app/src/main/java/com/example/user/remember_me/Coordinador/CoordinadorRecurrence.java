package com.example.user.remember_me.Coordinador;



import com.example.user.remember_me.Logica.LogicaRecurrence;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;

import java.util.ArrayList;

public class CoordinadorRecurrence {
    private LogicaRecurrence mlogicaRecurrence;

    private LogicaRecurrence getLogica(){
        return mlogicaRecurrence;
    }
    public void setLogica(LogicaRecurrence logicaRecurrence){
        this.mlogicaRecurrence = logicaRecurrence;
    }
    public void addRecurrence(RecurrenceVO recurrence){
        mlogicaRecurrence.validarAddRecurrence(recurrence);
    }
    public void deleteRecurrence(int id){
        mlogicaRecurrence.validarDeleteRecurrence(id);
    }

    public ArrayList<RecurrenceVO> listaRecurrence(){
        return mlogicaRecurrence.validarListRecurrence();
    }
    public RecurrenceVO buscarRecurrence(int id){
        return mlogicaRecurrence.validarBuscarRecurrence(id);
    }
}
