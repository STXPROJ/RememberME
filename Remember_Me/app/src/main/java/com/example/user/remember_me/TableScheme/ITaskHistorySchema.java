package com.example.user.remember_me.TableScheme;

public interface ITaskHistorySchema {
    String taskHistoryTable = "Task";
    String COLUMN_IDTASK = "idTask";
    String COLUMN_NAME = "name";
    String COLUMN_DESCRIPTION = "description";
    String COLUMN_DATE = "date";
    String COLUMN_RECURRENCE = "idRecurrence";
    String COLUMN_ISDONE = "isDone";
    String CONSTRAINT_FOREIGNKEY = "foreign key (" + COLUMN_RECURRENCE + ") references Recurrence ("+
            COLUMN_RECURRENCE + ")";
    String createTable = "Create table if not exists " + taskHistoryTable + " ("+
            COLUMN_IDTASK + " INTEGER primary key,"+ COLUMN_NAME + " text not null,"+
            COLUMN_DESCRIPTION + " text null," +
            COLUMN_DATE + " date null,"  + COLUMN_RECURRENCE + " int  null, "+
            COLUMN_ISDONE + " boolean default 0, " +
            CONSTRAINT_FOREIGNKEY +   ")";
    String [] taskColumn = new String[]{ COLUMN_IDTASK,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_DATE,
            COLUMN_RECURRENCE,COLUMN_ISDONE};



}
