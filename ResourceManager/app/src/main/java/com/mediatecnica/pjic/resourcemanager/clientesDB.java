package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class clientesDB extends SQLiteOpenHelper {
    public static String nombreC = "";
    public static String identificacionC = "";
    public static String telefonoC = "";
    public static String correoC = "";


    private static final int VERSION_BASE_DATOS = 1;

    private static final String NOMBRE_BASE_DATOS = " clientes";

    private static final String TABLA_CLIENTES = " clientesDB";

    private static final String COLUMNA_ID = " id";
    private static final String COLUMNA_NOMBRE = " nombre";
    private static final String COLUMNA_IDENTIFICACION = " identificacion";
    private static final String COLUMNA_TELEFONO = " telefono";
    private static final String COLUMNA_CORREO = " correo";


    public clientesDB(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLA_CLIENTES + "("
                + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COLUMNA_NOMBRE + " TEXT,"
                + COLUMNA_IDENTIFICACION + " TEXT,"
                + COLUMNA_TELEFONO + " TEXT,"
                + COLUMNA_CORREO + " TEXT )";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int VersionNueva) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CLIENTES);
        onCreate(db);
    }

    void addCliente(Clientes_Constructor clientes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, clientes.get_nombre());
        valores.put(COLUMNA_IDENTIFICACION, clientes.get_identificacion());
        valores.put(COLUMNA_TELEFONO, clientes.get_telefono());
        valores.put(COLUMNA_CORREO, clientes.get_correo());

        db.insert(TABLA_CLIENTES, null, valores);
        db.close();
    }

    Clientes_Constructor getClientes(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_CLIENTES, new String[]{COLUMNA_ID,
                        COLUMNA_NOMBRE, COLUMNA_IDENTIFICACION, COLUMNA_TELEFONO, COLUMNA_CORREO}, COLUMNA_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Clientes_Constructor clientes = new Clientes_Constructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        nombreC = cursor.getString(1);
        identificacionC = cursor.getString(2);
        telefonoC = cursor.getString(3);
        correoC = cursor.getString(4);

        return clientes;
    }

    Clientes_Constructor getClientesV(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_CLIENTES, new String[]{COLUMNA_ID,
                        COLUMNA_NOMBRE, COLUMNA_IDENTIFICACION, COLUMNA_TELEFONO, COLUMNA_CORREO}, COLUMNA_NOMBRE+ "=?",
                new String[]{nombre}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Clientes_Constructor clientes = new Clientes_Constructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        nombreC = cursor.getString(1);
        identificacionC = cursor.getString(2);
        telefonoC = cursor.getString(3);
        correoC = cursor.getString(4);

        return clientes;
    }

    public  int udDateCliente( Clientes_Constructor clientes ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, clientes.get_nombre());
        valores.put(COLUMNA_IDENTIFICACION, clientes.get_identificacion());
        valores.put(COLUMNA_TELEFONO, clientes.get_telefono());
        valores.put(COLUMNA_CORREO, clientes.get_correo());

        return db.update(TABLA_CLIENTES, valores, COLUMNA_ID + " = ?",
                new String[]{Integer.toString(Clientes.ayuda)});
    }
}