package com.example.user.remember_me.ModeloDAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.user.remember_me.CRUD.ABCRUD;
import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.ModeloDAO.Interface.IUserDAO;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;
import com.example.user.remember_me.ModeloVO.TaskVO;
import com.example.user.remember_me.ModeloVO.UserVO;
import com.example.user.remember_me.TableScheme.IUsuarioSchema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class UserDAO extends ABCRUD implements IUserDAO,IUsuarioSchema {
    private Cursor mFila;
    private ContentValues mRegistro = new ContentValues();
    private UserVO muser;

    public UserDAO(SQLiteDatabase db) {
        super(db);
    }

    protected UserVO cursorToEntity(Cursor consulta) {
        UserVO user = new UserVO();

        int idUserindex = 0;
        int idNameIndex = 0;
        int idApellidoIndex = 0;
        int userDateIndex = 0;
        int userCorreoIndex = 0;
        int usernameIndex = 0;
        if (mFila != null) {
            if (mFila.getColumnIndex(COLUMN_IDUSER) != -1) {
                idUserindex = mFila.getColumnIndexOrThrow(COLUMN_IDUSER);
                user.setidUser(mFila.getInt(idUserindex));
            }

            if (mFila.getColumnIndex(COLUMN_NOMBRE) != -1) {
                idNameIndex = mFila.getColumnIndexOrThrow(COLUMN_NOMBRE);
                user.setname(mFila.getString(idNameIndex));
            }
            if (mFila.getColumnIndex(COLUMN_APELLIDO) != -1) {
                idApellidoIndex = mFila.getColumnIndexOrThrow(COLUMN_APELLIDO);
                user.setapellido(mFila.getString(idApellidoIndex));
            }
            if (mFila.getColumnIndex(COLUMN_FECHANAC) != -1) {
                userDateIndex = mFila.getColumnIndexOrThrow(COLUMN_FECHANAC);
                user.setFechaNac(mFila.getString(userDateIndex));
            }
            if (mFila.getColumnIndex(COLUMN_EMAIL) != -1) {
                userCorreoIndex = mFila.getColumnIndexOrThrow(COLUMN_EMAIL);
                user.setcorreo(mFila.getString(userCorreoIndex));
            }
            if (mFila.getColumnIndex(COLUMN_USUARIO) != -1) {
                usernameIndex = mFila.getColumnIndexOrThrow(COLUMN_USUARIO);
                user.setusername(mFila.getString(usernameIndex));
            }
        }
        return user;
    }

    @Override
    public UserVO getUser() {

        mFila = super.consulta(userTable, COLUMNTASK, null, null, COLUMN_IDUSER, "1");
        if (mFila != null) {
            mFila.moveToFirst();
            while (!mFila.isAfterLast()) {
                muser = cursorToEntity(mFila);
                mFila.moveToNext();
            }
            mFila.close();
        }
        return muser;

    }

    @Override
    public boolean addUser(UserVO user) {
        setValues(user);
        try {
            return super.insert(userTable, getValues()) > 0;
        } catch (SQLiteConstraintException e) {
            Log.d("Database", e.getMessage());
            return false;
        }
    }

    @Override
    public int updateUser(UserVO user) {
        setValues(user);
        int u=0;
        try {
            super.update(userTable, getValues(), null, null);
            u++;
        } catch (SQLiteConstraintException e) {
            Log.d("Database", e.getMessage());

    }return u;

}
    private void setValues(UserVO user){

        mRegistro.put(COLUMN_USUARIO,user.getusername());
        mRegistro.put(COLUMN_NOMBRE,user.getapellido());
        mRegistro.put(COLUMN_APELLIDO,user.getapellido());
        mRegistro.put(COLUMN_FECHANAC,user.getFechaNac());
        mRegistro.put(COLUMN_EMAIL,user.getcorreo());
        mRegistro.put(COLUMN_CONTRASENA,user.getcontrasena());
    }
    private ContentValues getValues(){
        return mRegistro;
    }
}
