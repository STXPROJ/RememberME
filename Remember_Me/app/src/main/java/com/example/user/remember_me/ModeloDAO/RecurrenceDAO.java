package com.example.user.remember_me.ModeloDAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import android.database.Cursor;
import android.util.Log;

import com.example.user.remember_me.CRUD.ABCRUD;
import com.example.user.remember_me.ModeloDAO.Interface.IRecurrenceDAO;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;
import com.example.user.remember_me.TableScheme.IRecurrenceSchema;

import java.util.ArrayList;

public class RecurrenceDAO extends ABCRUD implements IRecurrenceDAO,IRecurrenceSchema {
    private Cursor mFila;
    private ContentValues mRegistro = new ContentValues();
    private RecurrenceVO mrecurrence;
    public RecurrenceDAO(SQLiteDatabase db){
        super(db);
    }


    @Override
    public RecurrenceVO fetchById(int id) {
        // final para que no sea sobreescrito y selectionArgs es para poder ser reemplazado en el query
        final String selectionArgs[] = {String.valueOf(id)};
        final String selection = COLUMN_IDRECURRENCE  + "= ? ";
         mFila = super.consulta(recurrenceTable,recurrenceColumn,selection,selectionArgs,COLUMN_IDRECURRENCE);
            if(mFila!=null){
                mFila.moveToFirst();
                while (!mFila.isAfterLast()) {
                    mrecurrence = cursorToEntity(mFila);
                    mFila.moveToNext();
                }mFila.close();}
        return mrecurrence;

    }

    @Override
    public ArrayList<RecurrenceVO> fetchAllRecurrence() {
        ArrayList<RecurrenceVO> listaRecurrence = new ArrayList<RecurrenceVO>();
        final String selectionArgs[] = {String.valueOf(0)};
        final String selection = COLUMN_ISCANCELLED  + " = ?";
        mFila = super.consulta(recurrenceTable,recurrenceColumn,selection,selectionArgs,COLUMN_IDRECURRENCE);
        if (mFila != null){
            mFila.moveToFirst();
            while(!mFila.isAfterLast()) {
                mrecurrence = cursorToEntity(mFila);
                listaRecurrence.add(mrecurrence);
                mFila.moveToNext();
            }mFila.close();
        }
        return listaRecurrence;
    }

    @Override
    public boolean addRecurrence(RecurrenceVO recurrence) {
        setValues(recurrence);
      try{
         return super.insert(recurrenceTable,getContentValues())>0;

      }catch (SQLiteConstraintException e){
          Log.d("Database",e.getMessage());
          return false;
      }
    }
    @Override
    public int deleteRecurrence(int id) {
        ContentValues isCancelled = new ContentValues();
        isCancelled.put(COLUMN_ISCANCELLED,1);
        final String selectionArgs[] = {String.valueOf(id)};
        final String selection = COLUMN_IDRECURRENCE + "= ?";
        try{
        return super.update(recurrenceTable,isCancelled,selection,selectionArgs);}
        catch (SQLiteConstraintException e){
            Log.d("Database",e.getMessage());
            return 0;
        }
    }
    @Override
    protected RecurrenceVO cursorToEntity(Cursor consulta) {
     RecurrenceVO  rec = new RecurrenceVO();

       // variables de indices de cursor

        int idIndex= 0;
        int nameIndex = 0;
        int descriptionIndex = 0;
        int intervaltypeIndex = 0;
        int intervalIndex = 0;

        if(mFila!=null){
       if (mFila.getColumnIndex(COLUMN_IDRECURRENCE )!=-1){
           idIndex = mFila.getColumnIndexOrThrow(COLUMN_IDRECURRENCE);
           rec.setidRecurrence(mFila.getInt(idIndex));}
        if(mFila.getColumnIndex(COLUMN_NAME)!=-1){
           nameIndex = mFila.getColumnIndexOrThrow(COLUMN_NAME);
           rec.setname(mFila.getString(nameIndex));}
        if (mFila.getColumnIndex(COLUMN_DESCRIPTION)!=-1){
           descriptionIndex = mFila.getColumnIndexOrThrow(COLUMN_DESCRIPTION);
           rec.setdescription(mFila.getString(descriptionIndex));
       }
         if (mFila.getColumnIndex(COLUMN_INTERVALTYPE)!=-1){
           mFila.getColumnIndexOrThrow(COLUMN_INTERVALTYPE);
           rec.settype(mFila.getString(intervaltypeIndex));
       }
        if (mFila.getColumnIndex(COLUMN_INTERVAL)!=-1){
           mFila.getColumnIndexOrThrow(COLUMN_INTERVAL);
           rec.setinterval(mFila.getInt(intervalIndex));
       }}
            return rec;
    }


    private void setValues(RecurrenceVO recurrence){
         mRegistro.put(COLUMN_NAME,recurrence.getname());
        mRegistro.put(COLUMN_DESCRIPTION,recurrence.getdescription());
        mRegistro.put(COLUMN_INTERVALTYPE,recurrence.gettype());
        mRegistro.put(COLUMN_INTERVAL,recurrence.getinterval());

    }
    private ContentValues getContentValues() {
        return mRegistro;
    }
}
