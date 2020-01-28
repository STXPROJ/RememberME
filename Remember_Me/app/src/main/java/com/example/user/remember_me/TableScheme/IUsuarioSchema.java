package com.example.user.remember_me.TableScheme;

public interface IUsuarioSchema {
    String userTable = "user";
    String COLUMN_IDUSER = "iduser";
    String COLUMN_NOMBRE = "name";
    String COLUMN_APELLIDO = "apellido";
    String COLUMN_FECHANAC = "fechaNac";
    String COLUMN_EMAIL = "email";
    String COLUMN_USUARIO = "usuario";
    String COLUMN_CONTRASENA = "contrasena";

    String createTable = "Create table if not exists " + userTable + " ("+
            COLUMN_IDUSER + " INTEGER primary key,"+ COLUMN_NOMBRE + " text not null,"+
            COLUMN_APELLIDO + " text null,"+ COLUMN_FECHANAC +" date null," +
            COLUMN_EMAIL + " text null," + COLUMN_USUARIO + " text null," + COLUMN_CONTRASENA + " text  null "+
            ")";
    String [] COLUMNTASK = new String[]{COLUMN_USUARIO,COLUMN_NOMBRE,COLUMN_APELLIDO,COLUMN_FECHANAC,COLUMN_EMAIL};

}
