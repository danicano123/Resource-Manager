package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;

public class login_Helper extends SQLiteOpenHelper {
    public static String name = "";
    public static String pass = "";

    // Todas las variables estáticas
    // Versión de la base de datos
    private static final int VERSION_BASE_DATOS = 1;

    // Nombre de la base de datos
    private static final String NOMBRE_BASE_DATOS = "usuarios";

    // Nombre de la tabla
    private static final String TABLA_CONTACTOS = "login";

    // Nombre de columnas de la tabla contactos
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String COLUMNA_CLAVE = "clave";

    public login_Helper(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    // Crear las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLA_CONTACTOS + "("
                + COLUMNA_ID + " INTEGER PRIMARY KEY," + COLUMNA_NOMBRE + " TEXT,"
                + COLUMNA_CLAVE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Actualizarlas tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int VersionNueva) {
        // Descar tabla vieja, si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONTACTOS);

        // Crear tablas nuevamente
        onCreate(db);
    }

    /**
     * Operaciones CRUD(Create, Read, Update, Delete) --> (Crear, Leer, Actualizar, Borrar)
     *
     */
    void addContacto(Contacto contacto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, contacto.getNombre()); // Nombre del contacto
        valores.put(COLUMNA_CLAVE, contacto.getClave()); // Teléfono del contacto

        // Insertar filas
        db.insert(TABLA_CONTACTOS, null, valores);
        db.close(); // Cerrando conexión a base de datos
    }
    Contacto getContacto(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_CONTACTOS, new String[]{COLUMNA_ID,
                    COLUMNA_NOMBRE, COLUMNA_CLAVE}, COLUMNA_NOMBRE + "=?",
            new String[]{nombre}, null, null, null, null);
    if (cursor != null)
        cursor.moveToFirst();


    Contacto contacto = new Contacto(Integer.parseInt(cursor.getString(0)),
            cursor.getString(1), cursor.getString(2));
         name = cursor.getString(1);
        pass = cursor.getString(2);
    // devolver contacto
    return contacto;


}
    }

