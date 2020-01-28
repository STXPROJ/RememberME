package com.example.user.remember_me.ModeloDAO.Interface;


import com.example.user.remember_me.ModeloVO.TaskVO;

import java.util.ArrayList;

public interface ITaskDAO {
    // Buscar por id
     TaskVO fetchById(int id);
    // Buscar todos las tareas
     ArrayList<TaskVO> fetchAllTask();
    // add Recurrence
     boolean addTask(TaskVO task);
    // delete Recurrence
     int deleteTask(int id);
     int updateTask(ArrayList<TaskVO> listaTask);
     ArrayList<TaskVO> getDoneTask();
     int setDoneTask(ArrayList<TaskVO> listaTask);
}
