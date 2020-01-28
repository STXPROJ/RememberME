package com.example.user.remember_me;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.remember_me.Conexion.BaseDeDatos;
import com.example.user.remember_me.Coordinador.CoordinadorRecurrence;
import com.example.user.remember_me.Coordinador.CoordinadorTask;
import com.example.user.remember_me.Coordinador.CoordinadorUser;
import com.example.user.remember_me.Logica.LogicaRecurrence;
import com.example.user.remember_me.Logica.LogicaTask;
import com.example.user.remember_me.Logica.LogicaUser;
import com.example.user.remember_me.ModeloVO.RecurrenceVO;
import com.example.user.remember_me.ModeloVO.TaskVO;
import com.example.user.remember_me.ModeloVO.UserVO;

import java.util.ArrayList;

public class BandejaDeEntrada extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CoordinadorUser mcoordUser;
    private LogicaUser mlogicaUser;
    private UserVO muser;
    private BaseDeDatos mDb;
    private TextView lblUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandeja_de_entrada);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set Logica y Coordinador de Usuario
        mcoordUser = new CoordinadorUser();
        mlogicaUser = new LogicaUser();
        mcoordUser.setLogica(mlogicaUser);
        mlogicaUser.setCoordinador(mcoordUser);
        // Abrir Base de Datos
        mDb = new BaseDeDatos(this);
        mDb.open();

        muser = mcoordUser.getUser();

        lblUser = (TextView) findViewById(R.id.nom_usuario);
       // lblUser.setText(muser.getusername());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fm = null;
        int id = item.getItemId();
        if (id == R.id.nav_nueva_tarea) {
            fm = new Nueva_Tarea_Fragment();
        } else if (id == R.id.nav_tarea_atrasada) {
            fm = new Tareas_Atrasadas_Fragment();
        } else if (id == R.id.nav_tarea_realizada) {
            fm = new Tareas_realizadas_Fragment();
        }else if (id == R.id.nav_perfil) {
            fm = new Perfil_Fragment();
        }else if (id == R.id.nav_proximas_tareas) {
        fm = new Proximas_tareas();
    }

        if(fm != null){

        FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.area,fm );
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
