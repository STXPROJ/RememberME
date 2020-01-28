package com.example.user.remember_me;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorTask;
import com.example.user.remember_me.Coordinador.CoordinadorUser;
import com.example.user.remember_me.Logica.LogicaTask;
import com.example.user.remember_me.Logica.LogicaUser;
import com.example.user.remember_me.ModeloVO.UserVO;


public class Perfil_Fragment extends Fragment {
    private CoordinadorUser mcoordUser;
    private LogicaUser mlogicaUser;
    private UserVO muser;
    private BaseDeDatos mDb;

    private TextView mtxtUser;
    private TextView mtxtNombre;
    private TextView mtxtApellido;
    private TextView mtxtFecha;
    private TextView mtxtEmail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_nueva__tarea_, container, false);
       mtxtUser = (TextView) view.findViewById(R.id.editT_usuario);
       mtxtNombre = (TextView) view.findViewById(R.id.editT_nom);
       mtxtApellido = (TextView) view.findViewById(R.id.editT_ape);
       mtxtFecha = (TextView) view.findViewById(R.id.editT_fecha_nac);
       mtxtEmail = (TextView) view.findViewById(R.id.editT_e);

        // Set Logica y Coordinador de Task
       mcoordUser = new CoordinadorUser();
        mlogicaUser = new LogicaUser();
        mcoordUser.setLogica(mlogicaUser);
        mlogicaUser.setCoordinador(mcoordUser);
        // Abrir Base de Datos
        mDb = new BaseDeDatos(getActivity());
        mDb.open();
        muser = mcoordUser.getUser();
        Log.d("Database",muser.getname());
        mtxtUser.setText("Username");
        /*mtxtNombre.setText((String)muser.getname());
        mtxtApellido.setText((String)muser.getapellido());
        mtxtFecha.setText((String)muser.getFechaNac());
        mtxtEmail.setText((String)muser.getcorreo());*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
