package com.example.user.remember_me.Conexion;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.user.remember_me.ModeloDAO.RecurrenceDAO;
import com.example.user.remember_me.ModeloDAO.TaskDAO;
import com.example.user.remember_me.ModeloDAO.UserDAO;
import com.example.user.remember_me.Registro;
import com.example.user.remember_me.TableScheme.IRecurrenceSchema;
import com.example.user.remember_me.TableScheme.ISchemaTask;
import com.example.user.remember_me.TableScheme.ITaskHistorySchema;
import com.example.user.remember_me.TableScheme.IUsuarioSchema;
/* Este es el conector a la base de datos sqlie, esta hace uso directo del esquema de la base de datos y las clase DAO
las cual es instanciada aqui como metodo statico para ser reutilizado en diversas ocasiones sin tener que ser instanciado otra vez
 */
public  class BaseDeDatos {
    private static final String TAG = "MyDatabase";
    private static final String DATABASE_NAME = "fdd.db";
    private static final int DATABASE_VERSION = 1;
    private DatabaseHelper mDbHelper;
    private final Context mContext;
    public static RecurrenceDAO mRecurrenceDAO;
    public static TaskDAO mTaskDAO;
    public static UserDAO mUserDAO;
    public BaseDeDatos open(){
        mDbHelper = new DatabaseHelper(mContext);
        SQLiteDatabase mdb = mDbHelper.getWritableDatabase();

        mRecurrenceDAO = new RecurrenceDAO(mdb);
        mTaskDAO = new TaskDAO(mdb);
        mUserDAO = new UserDAO(mdb);
        return this;
    }
    public void close(){
        mDbHelper.close();
    }
    public BaseDeDatos(Context context){
        this.mContext = context;
    }

    public class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(IRecurrenceSchema.createTable);
            db.execSQL(ISchemaTask.createTable);
            db.execSQL(ITaskHistorySchema.createTable);
            db.execSQL(IUsuarioSchema.createTable);
            db.execSQL("insert into Recurrence (name,description,intervaltype,interval) values ('Diario','','Dia',1)");
            db.execSQL("insert into Recurrence (name,description,intervaltype,interval) values ('Interdiario','','Dia',2)");
            db.execSQL("insert into Recurrence (name,description,intervaltype,interval) values ('Semanal','','Semana',1)");
            db.execSQL("insert into Recurrence (name,description,intervaltype,interval) values ('Quincenal','','Semana',1)");
            db.execSQL("insert into Recurrence (name,description,intervaltype,interval) values ('Mensual','','Mes',1)");
/*            Log.d("Database",ISchemaTask.trigger_before_insert);
            db.execSQL(ISchemaTask.trigger_before_insert);*/


           }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG,"Upgrading Database from " + oldVersion + "TO "+ newVersion+ " " +
                    "which destroy all date");

            db.execSQL("DROP TABLE IF EXISTS " + IRecurrenceSchema.recurrenceTable);
            db.execSQL("DROP TABLE IF EXISTS " + ISchemaTask.taskTable);
            db.execSQL("DROP TRIGGER IF EXISTS " + ISchemaTask.TRIGGER_INSERT);

            onCreate(db);
        }
    }
}