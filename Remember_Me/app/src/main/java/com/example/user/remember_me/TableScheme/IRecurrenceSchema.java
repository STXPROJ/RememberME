package com.example.user.remember_me.TableScheme;

public interface IRecurrenceSchema {
    String recurrenceTable = "Recurrence";
    String COLUMN_IDRECURRENCE = "idRecurrence";
    String COLUMN_NAME = "name";
    String COLUMN_DESCRIPTION = "description";
    String COLUMN_INTERVALTYPE = "intervalType";
    String COLUMN_INTERVAL = "interval";
    String COLUMN_ISCANCELLED = "isCancelled";

    String createTable = "create table  if not exists " + recurrenceTable +" (" +
            COLUMN_IDRECURRENCE + " INTEGER primary key, " + COLUMN_NAME +" text not null, "+
            COLUMN_DESCRIPTION +" text null, " + COLUMN_INTERVALTYPE + " text null, " +
            COLUMN_INTERVAL +" INTEGER null, " + COLUMN_ISCANCELLED +" boolean default 0" + ")";

    String [] recurrenceColumn = new String[]{COLUMN_IDRECURRENCE,COLUMN_NAME,COLUMN_DESCRIPTION,
                                COLUMN_INTERVALTYPE,COLUMN_ISCANCELLED};


}
