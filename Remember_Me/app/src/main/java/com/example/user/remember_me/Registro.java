package com.example.user.remember_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorUser;
import com.example.user.remember_me.Logica.LogicaUser;
import com.example.user.remember_me.ModeloVO.UserVO;

public class Registro extends AppCompatActivity {
    private EditText mnombre;
    private EditText mapellido;
    private EditText mfecha;
    private EditText memail;
    private EditText musuario;
    private EditText mpassword;
    private Button btnSave;

    private CoordinadorUser mcoordUser;
    private LogicaUser mlogicaUser;
    private UserVO muser;
    private BaseDeDatos mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mdb = new BaseDeDatos(getBaseContext());
        mdb.open();

        mcoordUser = new CoordinadorUser();
        mlogicaUser = new LogicaUser();
        mcoordUser.setLogica(mlogicaUser);
        mlogicaUser.setCoordinador(mcoordUser);

        mnombre = (EditText) findViewById(R.id.editT_nom);
        mapellido  = (EditText) findViewById(R.id.editT_ape);
        memail  = (EditText) findViewById(R.id.editT_e);
        mfecha  = (EditText) findViewById(R.id.editT_fecha_nac);
        musuario  = (EditText) findViewById(R.id.editT_usuario);
        mpassword  = (EditText) findViewById(R.id.editT_pass);
        btnSave = (Button)findViewById(R.id.btnContinuar);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muser = new UserVO();
                muser.setusername(musuario.getText().toString());
                muser.setname(mnombre.getText().toString());
                muser.setapellido(mapellido.getText().toString());
                muser.setFechaNac(mfecha.getText().toString());
                muser.setcorreo(memail.getText().toString());
                muser.setcontrasena(mpassword.getText().toString());
                mcoordUser.addUser(muser,getBaseContext());
                Intent i = new Intent(Registro.this,BandejaDeEntrada.class);
                startActivity(i);
            }
        });

    }
}
