package com.example.user.remember_me.ModeloDAO.Interface;


import com.example.user.remember_me.ModeloVO.RecurrenceVO;

import java.util.ArrayList;

public interface IRecurrenceDAO {
    // Buscar por id
     RecurrenceVO fetchById(int id);
    // Buscar todos las recurrencias
     ArrayList<RecurrenceVO> fetchAllRecurrence();
    // add Recurrence
     boolean addRecurrence(RecurrenceVO recurrence);
    // delete Recurrence
     int deleteRecurrence(int id);



}
