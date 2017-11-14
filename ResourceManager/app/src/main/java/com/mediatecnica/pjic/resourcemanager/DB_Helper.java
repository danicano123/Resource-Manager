package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {
    public static String nombreA = "";
    public static String refA = "";
    public static String pVentaA;
    public static String pCompraA;
    public static String cantidadA;
    public static String proveedorA = "";

    // Todas las variables estáticas
    // Versión de la base de datos
    private static final int VERSION_BASE_DATOS = 1;

    // Nombre de la base de datos
    private static final String NOMBRE_BASE_DATOS = " articulos";

    // Nombre de la tabla
    private static final String TABLA_ARTICULOS = " articulosDB";

    // Nombre de columnas de la tabla contactos
    private static final String COLUMNA_ID = " id";
    private static final String COLUMNA_NOMBRE = " nombre";
    private static final String COLUMNA_REF = " referencia";
    private static final String COLUMNA_PRECIO_COMPRA = " precioCompra";
    private static final String COLUMNA_PRECIO_VENTA = " precioVenta";
    private static final String COLUMNA_CANTIDAD = " cantidad";
    private static final String COLUMNA_PROVEEDOR = " proveedor";


    public DB_Helper(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    // Crear las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLA_ARTICULOS + "("
                + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COLUMNA_NOMBRE + " TEXT ,"
                + COLUMNA_REF + " TEXT,"
                + COLUMNA_PRECIO_COMPRA + " TEXT ,"
                + COLUMNA_PRECIO_VENTA + " TEXT ,"
                + COLUMNA_CANTIDAD + " TEXT ,"
                + COLUMNA_PROVEEDOR + " TEXT )";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    // Actualizarlas tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int VersionNueva) {
        // Descar tabla vieja, si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ARTICULOS);

        // Crear tablas nuevamente
        onCreate(db);
    }

    /**
     * Operaciones CRUD(Create, Read, Update, Delete) --> (Crear, Leer, Actualizar, Borrar)
     */
    void addArticulo(Articulos_Constructor articulos) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, articulos.getNombre());
        valores.put(COLUMNA_REF, articulos.getRef());
        valores.put(COLUMNA_PRECIO_COMPRA, articulos.getPCompra());
        valores.put(COLUMNA_PRECIO_VENTA, articulos.getPVenta());
        valores.put(COLUMNA_CANTIDAD, articulos.getCantidad());
        valores.put(COLUMNA_PROVEEDOR, articulos.getProovedor());

        // Insertar filas
        db.insert(TABLA_ARTICULOS, null, valores);
        db.close(); // Cerrando conexión a base de datos
    }

    Articulos_Constructor getArticulo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_ARTICULOS, new String[]{
                        COLUMNA_ID, COLUMNA_NOMBRE, COLUMNA_REF, COLUMNA_PRECIO_COMPRA, COLUMNA_PRECIO_VENTA, COLUMNA_CANTIDAD, COLUMNA_PROVEEDOR}
                , COLUMNA_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Articulos_Constructor articulos = new Articulos_Constructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
                , cursor.getString(5), cursor.getString(6));
        // devolver articulo
        nombreA = cursor.getString(1);
        refA = cursor.getString(2);
        pVentaA = cursor.getString(4);
        pCompraA = cursor.getString(3);
        cantidadA = cursor.getString(5);
        proveedorA = cursor.getString(6);
        return articulos;
    }

     public  int upDateArticulo( Articulos_Constructor articulos ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNA_NOMBRE, articulos.getNombre());
        valores.put(COLUMNA_REF, articulos.getRef());
        valores.put(COLUMNA_PRECIO_COMPRA, articulos.getPCompra());
        valores.put(COLUMNA_PRECIO_VENTA, articulos.getPVenta());
        valores.put(COLUMNA_CANTIDAD, articulos.getCantidad());
        valores.put(COLUMNA_PROVEEDOR, articulos.getProovedor());
        int alv = articulos.get_id();

       return db.update(TABLA_ARTICULOS, valores, COLUMNA_ID + " = ?",
                new String[]{Integer.toString(Catalogo.ayuda)});
    }
    /*public List<Articulos_Constructor> getAllItems() {
        List<Articulos_Constructor> lista = new ArrayList<Articulos_Constructor>();
        // Preguntar por toda la tabla
        String selectQuery = "SELECT  * FROM " + TABLA_ARTICULOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // pasar por todas las filas y adicionarlas a la lista
        if (cursor.moveToFirst()) {
            do {
                Articulos_Constructor listas = new Articulos_Constructor();
                listas.setID(Integer.parseInt(cursor.getString(0)));
                listas.setNombre(cursor.getString(1));
                listas.setRef(cursor.getString(2));
                listas.setPCompra(cursor.getString(3));
                listas.setPVenta(cursor.getString(4));
                listas.setCantidad(cursor.getString(5));
                listas.setProovedor(cursor.getString(6));
                // Adding contacto to list
                lista.add(listas);
                nombreA = cursor.getString(1);
                refA = cursor.getString(2);
                pVentaA = cursor.getString(3);
                pCompraA = cursor.getString(4);
                cantidadA = cursor.getString(5);
                proveedorA = cursor.getString(6);
            } while (cursor.moveToNext());
        }

        // retornar la lista de contactos
        return lista;
    }*/

}