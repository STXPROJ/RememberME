package com.example.user.remember_me.TableScheme;

public interface ISchemaTask {
    String taskTable = "Task";
    String COLUMN_IDTASK = "idTask";
    String COLUMN_NAME = "name";
    String COLUMN_DESCRIPTION = "description";
    String COLUMN_ISCANCELLED = "isCancelled";
    String COLUMN_CREATEDDATE = "createdDate";
    String COLUMN_DATE = "date";
    String COLUMN_NEXTDATE = "nextDate";
    String COLUMN_RECURRENCE = "idRecurrence";
    String COLUMN_DONE = "done";
    String COLUMN_STARTIME = "startime";
    String  COLUMN_ENDTIME = "endtime";
    String CONSTRAINT_FOREIGNKEY = "foreign key (" + COLUMN_RECURRENCE + ") references Recurrence ("+
            COLUMN_RECURRENCE + ")";
    String TRIGGER_INSERT = "trigger_before_insert";

    String createTable = "Create table if not exists " + taskTable + " ("+
            COLUMN_IDTASK + " INTEGER primary key,"+ COLUMN_NAME + " text not null,"+
            COLUMN_DESCRIPTION + " text null,"+ COLUMN_CREATEDDATE +" date null," +
            COLUMN_DATE + " date null," + COLUMN_NEXTDATE + " date null," + COLUMN_RECURRENCE + " int  null, "+
            COLUMN_ISCANCELLED + " boolean default 0," + COLUMN_DONE + " int default 0, " +
            COLUMN_STARTIME + " date null, " + COLUMN_ENDTIME + " date null, "+CONSTRAINT_FOREIGNKEY + ")";
    String [] taskColumn = new String[]{COLUMN_IDTASK,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_DATE};
    String [] taskDateTimaColumn = new String[]{COLUMN_IDTASK,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_DATE,COLUMN_STARTIME,COLUMN_ENDTIME};
  /*  String trigger_update_date = "Create trigger trigger_update_date before update on " + taskTable +
            " when " + COLUMN_DONE + " = 1 begin update "+taskTable + "  set " +COLUMN_DATE +" = "+COLUMN_NEXTDATE +", " + COLUMN_DONE
            + "  = 0;" +
            " end";*/
  /*  String trigger_before_insert = "Create trigger " + TRIGGER_INSERT + " before insert on " + taskTable +
          " Begin update nextDate = Date(NEW." + COLUMN_DATE + ", '+1 Days') where " + COLUMN_IDTASK +
          " = NEW."+COLUMN_IDTASK;*/

}
