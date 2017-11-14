package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by usuario on 13/11/2017.
 */

public class ventasDB extends SQLiteOpenHelper {


    public static int idA = 0;
    public static String nombreV = "";
    public static String refV = "";
    public static String pagoV = "";
    public static String cantidadV = "";
    public static String clienteV = "";
    public static String proveedorV = "";

    private static final int VERSION_BASE_DATOS = 1;

    private static final String NOMBRE_BASE_DATOS = " ventas ";

    private static final String TABLA_VENTAS = " ventasDB ";

    private static final String COLUMNA_ID = " id";
    private static final String COLUMNA_NOMBRE = " nombre";
    private static final String COLUMNA_REF = " referencia";
    private static final String COLUMNA_PAGO = " pago ";
    private static final String COLUMNA_CANTIDAD = " cantidad ";
    private static final String COLUMNA_CLIENTE = " cliente ";
    private static final String COLUMNA_PROVEEDOR = " proveedor";


    public ventasDB(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = " CREATE TABLE " + TABLA_VENTAS + "("
                + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMNA_NOMBRE + " TEXT,"
                + COLUMNA_REF + " TEXT,"
                + COLUMNA_PAGO + " TEXT,"
                + COLUMNA_CANTIDAD + " TEXT,"
                + COLUMNA_CLIENTE + " TEXT,"
                + COLUMNA_PROVEEDOR + " TEXT )";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int VersionNueva) {
        // Descar tabla vieja, si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_VENTAS);
        onCreate(db);
    }
    void addVenta(ventas_Constructor ventas) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, ventas.getNombre());
        valores.put(COLUMNA_REF, ventas.getRef());
        valores.put(COLUMNA_PAGO, ventas.getPago());
        valores.put(COLUMNA_CANTIDAD, ventas.getCantidad());
        valores.put(COLUMNA_CLIENTE, ventas.getCliente());
        valores.put(COLUMNA_PROVEEDOR, ventas.getProovedor());

        // Insertar filas
        db.insert(TABLA_VENTAS, null, valores);
        db.close(); // Cerrando conexión a base de datos
    }

    ventas_Constructor getVenta(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_VENTAS, new String[]{
                        COLUMNA_ID, COLUMNA_NOMBRE, COLUMNA_REF, COLUMNA_PAGO, COLUMNA_CANTIDAD, COLUMNA_CLIENTE, COLUMNA_PROVEEDOR}
                , COLUMNA_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ventas_Constructor articulos = new ventas_Constructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
                , cursor.getString(5), cursor.getString(6));

        nombreV = cursor.getString(1);
        refV = cursor.getString(2);
        pagoV = cursor.getString(3);
        cantidadV = cursor.getString(4);
        clienteV = cursor.getString(5);
        proveedorV = cursor.getString(6);
        return articulos;
    }
}

   /* public ventas_Constructor getVenta(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_VENTAS, new String[]{COLUMNA_ID,
                        COLUMNA_NOMBRE, COLUMNA_REF, COLUMNA_PRECIO_COMPRA, COLUMNA_PRECIO_VENTA, COLUMNA_CANTIDAD, COLUMNA_PROVEEDOR}, COLUMNA_ID + "=?",
                new String[]{Integer.toString(idA)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        ventas_Constructor venta = new ventas_Constructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
                , cursor.getString(5), cursor.getString(6));
        nombreV = cursor.getString(1);
        refV = cursor.getString(2);
        pagoV = cursor.getString(3);
        cantidadV = cursor.getString(4);
        ClienteV = cursor.getString(5);
        proveedorV = cursor.getString(6);
        return venta;
}*/
