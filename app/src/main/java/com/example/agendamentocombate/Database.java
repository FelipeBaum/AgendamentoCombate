package com.example.agendamentocombate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Versão Database
    private static final int DATABASE_VERSION = 1;

    // Database
    private static final String DATABASE_NAME = "AgendamentoCombate";

    // Tabelas
    private static final String TABLE_USUARIO = "usuario";
    private static final String TABLE_ARENA = "arena";
    private static final String TABLE_ROBO = "robo";
    private static final String TABLE_COMBATE = "combate";

    // Arena
    private static final String ID_ARENA = "id_arena";
    private static final String NOME_ARENA = "nome";

    // Usuarios
    private static final String ID_USUARIO = "id_usuario";
    private static final String NOME_USUARIO = "nome";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";
    private static final String NIVEL = "nivel";

    // Robo
    private static final String ID_ROBO = "id_robo";
    private static final String NOME_ROBO = "nome";
    private static final String CATEGORIA_ROBO = "categoria";
    private static final String STATUS = "status";
    private static final String ROBO_ID_USUARIO = "id_usuario";

    // Combate
    private static final String ID_COMBATE = "id_combate";
    private static final String ID_ROBO1 = "id_robo1";
    private static final String ID_ROBO2 = "id_robo2";
    private static final String DATA = "daya";
    private static final String CATEGORIA = "categoria";
    private static final String ARENA = "arena";

    // Table Create
    // Todo table create statement
    private static final String CREATE_TABLE_ARENA = "CREATE TABLE "
            + TABLE_ARENA + "(" + ID_ARENA + " INTEGER PRIMARY KEY," + NOME_ARENA
            + " TEXT)";

    // Tag table create statement
    private static final String CREATE_TABLE_USUARIO = "CREATE TABLE " + TABLE_USUARIO
            + "(" + ID_USUARIO + " INTEGER PRIMARY KEY," + NOME_USUARIO + " TEXT,"
            + USUARIO + " TEXT,"+ SENHA + " TEXT,"+ NIVEL + " TEXT)";

    // todo_tag table create statement
    private static final String CREATE_TABLE_ROBO = "CREATE TABLE " + TABLE_ROBO
            + "(" + ID_ROBO + " INTEGER PRIMARY KEY," + NOME_ROBO + " TEXT,"
            + CATEGORIA_ROBO + " TEXT,"+ STATUS + " TEXT,"+ ROBO_ID_USUARIO + " INTEGER,"
            +"FOREIGN KEY ("+ROBO_ID_USUARIO+") REFERENCES "+TABLE_USUARIO+" ("+ID_USUARIO+"))";

    private static final String CREATE_TABLE_COMBATE = "CREATE TABLE "
            + TABLE_COMBATE + "(" + ID_COMBATE + " INTEGER PRIMARY KEY,"
            + ID_ROBO1 + " INTEGER," + ID_ROBO2 + " INTEGER,"
            + DATA + " DATETIME,"+ CATEGORIA + " TEXT,"+ ARENA + " INTEGER,"
            +"FOREIGN KEY ("+ID_ROBO1+") REFERENCES "+TABLE_ROBO+" ("+ID_ROBO+"),"
            +"FOREIGN KEY ("+ID_ROBO2+") REFERENCES "+TABLE_ROBO+" ("+ID_ROBO+"),"
            +"FOREIGN KEY ("+ARENA+") REFERENCES "+TABLE_ARENA+" ("+ID_ARENA+"))";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_ARENA);
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_ROBO);
        db.execSQL(CREATE_TABLE_COMBATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARENA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROBO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMBATE);

        // create new tables
        onCreate(db);
    }
}
