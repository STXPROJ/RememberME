package com.example.user.remember_me;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityLauncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        delayedd();




    }
    private void delayedd(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                        .getBoolean("isFirstRun", true);

                if (isFirstRun) {
                    startActivity(new Intent (ActivityLauncher.this, Registro.class));
                    Toast.makeText(ActivityLauncher.this, "Bienvendio a RememberME Agenda Virtual", Toast.LENGTH_LONG)
                            .show();
                    Log.d("Database","Primera vez que inicia");
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isFirstRun", false).commit();
                }
                else{
                    startActivity(new Intent(ActivityLauncher.this,BandejaDeEntrada.class));
                }
            }
        }, 5000);   //5 seconds
    }

}
