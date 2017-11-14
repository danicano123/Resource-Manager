package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar_producto extends AppCompatActivity {

    final DB_Helper helperA = new DB_Helper(this);
    final Catalogo helperM = new Catalogo();

    Button botonInsertar;
    EditText textoref, textonombre, textoprecioc, textopreciov,
    textocantidad, textoproveedor;

    String nombre;
    String ref;
    String precioCompra;
    String precioVenta;
    String cantidad;
    String proveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        textoref = (EditText)findViewById(R.id.etReferencia);
        textonombre = (EditText)findViewById(R.id.etNombre);
        textoprecioc = (EditText)findViewById(R.id.etPreciocompra);
        textopreciov = (EditText)findViewById(R.id.etPrecioventa);
        textocantidad = (EditText)findViewById(R.id.etCantidad);
        textoproveedor = (EditText)findViewById(R.id.etDistribuidor);


        botonInsertar = (Button)findViewById(R.id.insert_button);

    }
    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Agregar_producto.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Agregar_producto.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Agregar_producto.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Agregar_producto.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(Agregar_producto.this, Catalogo.class);
        startActivity(intent);
    }
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(Agregar_producto.this, Clientes.class);
        startActivity(intent);
    }*/

   public void insertArticulos(View v){

         nombre = textonombre.getText().toString();
         ref = textoref.getText().toString();
         precioCompra = textoprecioc.getText().toString();
         precioVenta = textopreciov.getText().toString();
         cantidad = textocantidad.getText().toString();
         proveedor = textoproveedor.getText().toString();

       helperA.addArticulo(new Articulos_Constructor(nombre,ref,precioCompra,precioVenta,cantidad,proveedor));
       Toast.makeText(getApplicationContext(), "El artículo "+nombre+" ha sido guardado con éxito", Toast.LENGTH_SHORT).show();
       Intent intent = new Intent(Agregar_producto.this, Catalogo.class);
       startActivity(intent);
   }




}
