package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Catalogo extends AppCompatActivity {
    final DB_Helper helperA = new DB_Helper(this);
    public static int ayuda;

    TextView tvNombre1, tvref1, tvpcompra1, tvpventa1, tvcantidad1, tvproveedor1,
            tvNombre2, tvref2, tvpcompra2, tvpventa2, tvcantidad2, tvproveedor2,
            tvNombre3, tvref3, tvpcompra3, tvpventa3, tvcantidad3, tvproveedor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);


        tvNombre1 = (TextView) findViewById(R.id.textoNombre1);
        tvNombre2 = (TextView) findViewById(R.id.textoNombre2);
        tvNombre3 = (TextView) findViewById(R.id.textoNombre3);
        tvref1 = (TextView) findViewById(R.id.textoRef1);
        tvref2 = (TextView) findViewById(R.id.textoRef2);
        tvref3 = (TextView) findViewById(R.id.textoRef3);
        // tvpcompra1 = (TextView) findViewById(R.id.texto);
        //tvpcompra2 = (TextView) findViewById(R.id.textoNombre1);
        // tvpcompra3 = (TextView) findViewById(R.id.textoNombre1);
        tvpventa1 = (TextView) findViewById(R.id.textoPrecio1);
        tvpventa2 = (TextView) findViewById(R.id.textoPrecio2);
        tvpventa3 = (TextView) findViewById(R.id.textoPrecio3);
        tvcantidad1 = (TextView) findViewById(R.id.textoCantidad1);
        tvcantidad2 = (TextView) findViewById(R.id.textoCantidad2);
        tvcantidad3 = (TextView) findViewById(R.id.textoCantidad3);
        tvproveedor1 = (TextView) findViewById(R.id.textoDistribuidor1);
        tvproveedor2 = (TextView) findViewById(R.id.textoDistribuidor2);
        tvproveedor3 = (TextView) findViewById(R.id.textoDistribuidor3);
        SQLiteDatabase bd = helperA.getReadableDatabase();

        try {
            helperA.getArticulo(1);

            tvNombre1.setText(DB_Helper.nombreA);
            tvref1.setText(DB_Helper.refA);
            tvpventa1.setText(DB_Helper.pVentaA);
            tvcantidad1.setText(DB_Helper.cantidadA);
            tvproveedor1.setText(DB_Helper.proveedorA.toString());

        } catch (Exception e){}
        try {
            helperA.getArticulo(2);

            tvNombre2.setText(DB_Helper.nombreA);
            tvref2.setText(DB_Helper.refA);
            tvpventa2.setText(DB_Helper.pVentaA);
            tvcantidad2.setText(DB_Helper.cantidadA);
            tvproveedor2.setText(DB_Helper.proveedorA);

        } catch (Exception e){}

        try {
            helperA.getArticulo(3);

            tvNombre3.setText(DB_Helper.nombreA);
            tvref3.setText(DB_Helper.refA);
            tvpventa3.setText(DB_Helper.pVentaA);
            tvcantidad3.setText(DB_Helper.cantidadA);
            tvproveedor3.setText(DB_Helper.proveedorA);

        }catch (Exception e){}
        bd.close();

    }

       /* List<Articulos_Constructor> list = db.getAllItems();
        for (Articulos_Constructor cn : list) {
            tvNombre1.setText(DB_Helper.nombreA);
            tvref1.setText(DB_Helper.refA);
            tvpventa1.setText(DB_Helper.pVentaA);
            tvcantidad1.setText(DB_Helper.cantidadA);
            tvproveedor1.setText(DB_Helper.proveedorA);



        }


    }*/

    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Catalogo.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Catalogo.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Catalogo.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Catalogo.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
            }
   public void ir_movimiento(View v) {
        Intent intent = new Intent(Catalogo.this, Clientes.class);
        startActivity(intent);
    }

    public void vender1 (View v){
        ayuda = 1;
        Intent intent = new Intent(Catalogo.this, Venta.class);
        startActivity(intent);
    }
    public void vender2 (View v){
        ayuda = 2;
        Intent intent = new Intent(Catalogo.this, Venta.class);
        startActivity(intent);
    }
    public void vender3 (View v){
        ayuda = 3;
        Intent intent = new Intent(Catalogo.this, Venta.class);
        startActivity(intent);
    }
    public void act1 (View v){
        ayuda = 1;
        Intent intent = new Intent(Catalogo.this, Actualizar_producto.class);
        startActivity(intent);
    }
    public void act2 (View v){
        ayuda = 2;
        Intent intent = new Intent(Catalogo.this, Actualizar_producto.class);
        startActivity(intent);
    }
    public void act3 (View v){
        ayuda = 3;
        Intent intent = new Intent(Catalogo.this, Actualizar_producto.class);
        startActivity(intent);
    }



    }

