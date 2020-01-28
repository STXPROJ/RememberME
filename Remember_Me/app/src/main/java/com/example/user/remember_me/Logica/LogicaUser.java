package com.example.user.remember_me.Logica;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorUser;
import com.example.user.remember_me.ModeloVO.TaskVO;
import com.example.user.remember_me.ModeloVO.UserVO;

import java.util.ArrayList;

public class LogicaUser {
    private CoordinadorUser mcoordUser;
    private UserVO muser;
    public void setCoordinador(CoordinadorUser coorduser) {
        this.mcoordUser = coorduser;
    }

    public void validaraddUser(UserVO user, Context context) {
        if (user.getname().isEmpty() || user.getapellido().isEmpty() || user.getcorreo().isEmpty() ||
                user.getcontrasena().isEmpty() || user.getFechaNac().isEmpty()) {
            Toast.makeText(context, "Debe Completar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            boolean isSaved = BaseDeDatos.mUserDAO.addUser(user);

            if (isSaved == true) {
                Toast.makeText(context, "Usuario Registrado con exito", Toast.LENGTH_LONG).show();
                Log.d("Database", "Registro de la tabla Usuario Anadido");
            } else {
                Toast.makeText(context, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
            }
        } }

    public void validarUpdateUser(UserVO user){
        int isUpdated = BaseDeDatos.mUserDAO.updateUser(user);
        if (isUpdated !=0){
            Log.d("Database","Se marcaron " + isUpdated + " tareas realizadas");

        }
    }
    public UserVO validarBuscaruser(){
        muser = BaseDeDatos.mUserDAO.getUser();
        if(muser!= null){
            Log.d("Database","Se encontro el usuario");
            return muser;
        } else {
            Log.d("Database","No se encontro el usuario");
            return null;
        }
    }
}