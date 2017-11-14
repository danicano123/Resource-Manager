package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actualizar_producto extends AppCompatActivity {
    Button botonAct;
    EditText textoref, textonombre, textoprecioc, textopreciov,
            textocantidad, textoproveedor;

    DB_Helper helperA = new DB_Helper(this);
    String nombre;
    String ref;
    String precioCompra;
    String precioVenta;
    String cantidad;
    String proveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_producto);

        textoref = (EditText)findViewById(R.id.etReferenciaA);
        textonombre = (EditText)findViewById(R.id.etNombreA);
        textoprecioc = (EditText)findViewById(R.id.etPreciocompraA);
        textopreciov = (EditText)findViewById(R.id.etPrecioventaA);
        textocantidad = (EditText)findViewById(R.id.etCantidadA);
        textoproveedor = (EditText)findViewById(R.id.etDistribuidorA);
        SQLiteDatabase db = helperA.getReadableDatabase();

        try {
            helperA.getArticulo(Catalogo.ayuda);

            textonombre.setText(DB_Helper.nombreA);
            textoref.setText(DB_Helper.refA);
            textoprecioc.setText(DB_Helper.pCompraA);
            textopreciov.setText(DB_Helper.pVentaA);
            textocantidad.setText(DB_Helper.cantidadA);
            textoproveedor.setText(DB_Helper.proveedorA);

        } catch (Exception e){}
        try {
            helperA.getArticulo(Catalogo.ayuda);

            textonombre.setText(DB_Helper.nombreA);
            textoref.setText(DB_Helper.refA);
            textoprecioc.setText(DB_Helper.pCompraA);
            textopreciov.setText(DB_Helper.pVentaA);
            textoproveedor.setText(DB_Helper.proveedorA);
            textocantidad.setText(DB_Helper.cantidadA);

        } catch (Exception e){}

        try {
            helperA.getArticulo(Catalogo.ayuda);

            textonombre.setText(DB_Helper.nombreA);
            textoref.setText(DB_Helper.refA);
            textoprecioc.setText(DB_Helper.pCompraA);
            textopreciov.setText(DB_Helper.pVentaA);
            textoproveedor.setText(DB_Helper.proveedorA);
            textocantidad.setText(DB_Helper.cantidadA);

        }catch (Exception e){}
        db.close();

    }
    public  void btnAct (View v){

        nombre = textonombre.getText().toString();
        ref = textoref.getText().toString();
        precioCompra = textoprecioc.getText().toString();
        precioVenta = textopreciov.getText().toString();
        cantidad = textocantidad.getText().toString();
        proveedor = textoproveedor.getText().toString();
        helperA.upDateArticulo(new Articulos_Constructor(nombre,ref,precioCompra,precioVenta,cantidad,proveedor));
        Intent intent = new Intent(Actualizar_producto.this, Catalogo.class);
        startActivity(intent);
    }

    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Actualizar_producto.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Actualizar_producto.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Actualizar_producto.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Actualizar_producto.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(Actualizar_producto.this, Catalogo.class);
        startActivity(intent);
    }
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(Actualizar_producto.this, movimiento.class);
        startActivity(intent);
    }*/
}
