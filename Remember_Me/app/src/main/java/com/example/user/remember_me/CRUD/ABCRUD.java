package com.example.user.remember_me.CRUD;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* Esta es una clase abstracta llamada CRUD (Create, Read, Update y Delete)
que declara los metodos para luego ser implementados en las diferentes clases que se tenga.
Ayuda mucho a reutilizar codio
 */
public abstract class ABCRUD {
    // Declarar Base De Datos
    public SQLiteDatabase mdb;

    public ABCRUD(SQLiteDatabase db) {
        this.mdb = db;
    }

    public int delete(String table,String whereClause,String[] whereArgs){
        return mdb.delete(table,whereClause,whereArgs);
    }
    public long insert(String table,ContentValues values){
        return mdb.insert(table,null,values);
    }
    public Cursor consulta(String table,String[] columns,String whereClause,String [] whereArgs,String orderSort){
        final Cursor fila = mdb.query(table,columns,whereClause,whereArgs,null,null,orderSort);
        return fila;
        }

    protected abstract <T> T cursorToEntity(Cursor consulta);

    public Cursor consulta(String table,String[] columns,String whereClause,String[] whereArgs,String orderSort,
                           String limit){
        return mdb.query(table,columns,whereClause,whereArgs,null,null,orderSort,limit);

    }
    public Cursor consulta(String table,String[] columns,String whereClause,String[] whereArgs,String orderSort,
                           String having,String groupby,String limit){
     return mdb.query(table,columns,whereClause,whereArgs,orderSort,having,groupby,limit);
    }
    public int update(String table,ContentValues values,String whereClause,String[] whereArgs){
      return  mdb.update(table,values,whereClause,whereArgs);
    }
    public Cursor rawQuery(String sql,String[]whereArgs){
        return mdb.rawQuery(sql,whereArgs);
    }
    }

