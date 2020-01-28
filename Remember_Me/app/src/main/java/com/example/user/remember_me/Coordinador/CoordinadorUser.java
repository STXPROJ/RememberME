package com.example.user.remember_me.Coordinador;

import android.content.Context;

import com.example.user.remember_me.Logica.LogicaUser;
import com.example.user.remember_me.ModeloVO.UserVO;

public class CoordinadorUser {
    private LogicaUser mlogicaUser;

    private LogicaUser getLogicaUser(){
        return mlogicaUser;
    }
    public void setLogica(LogicaUser logicauser){
        this.mlogicaUser = logicauser;
    }
public void addUser(UserVO user, Context context){
        mlogicaUser.validaraddUser(user,context);
}
public void actualizarUser(UserVO user){
      mlogicaUser.validarUpdateUser(user);
}
public UserVO getUser(){
        return mlogicaUser.validarBuscaruser();
}
}
