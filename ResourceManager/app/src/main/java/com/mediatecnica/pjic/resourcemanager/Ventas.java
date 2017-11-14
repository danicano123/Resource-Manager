package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ventas extends AppCompatActivity {
    TextView tvNombre1, tvref1, tvpago1, tvcantidad1, tvcliente1, tvproveedor1,
             tvNombre2, tvref2, tvpago2, tvcantidad2, tvcliente2, tvproveedor2,
             tvNombre3, tvref3, tvpago3, tvcantidad3, tvcliente3, tvproveedor3;
    final ventasDB helperV = new ventasDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        tvNombre1 = (TextView) findViewById(R.id.txnombre1);
        tvNombre2 = (TextView) findViewById(R.id.txnombre2);
        tvNombre3 = (TextView) findViewById(R.id.txnombre3);
        tvref1 = (TextView) findViewById(R.id.txref1);
        tvref2 = (TextView) findViewById(R.id.txref2);
        tvref3 = (TextView) findViewById(R.id.txref3);
        tvpago1 = (TextView) findViewById(R.id.txpago1);
        tvpago2 = (TextView) findViewById(R.id.txpago2);
        tvpago3 = (TextView) findViewById(R.id.txpago3);
        tvcantidad1 = (TextView) findViewById(R.id.txcantidad1);
        tvcantidad2 = (TextView) findViewById(R.id.txcantidad2);
        tvcantidad3 = (TextView) findViewById(R.id.txcantidad3);
        tvcliente1 = (TextView) findViewById(R.id.txcliente1);
        tvcliente2 = (TextView) findViewById(R.id.txcliente2);
        tvcliente3 = (TextView) findViewById(R.id.txcliente3);
        tvproveedor1 = (TextView) findViewById(R.id.txproveedor1);
        tvproveedor2 = (TextView) findViewById(R.id.txproveedor2);
        tvproveedor3 = (TextView) findViewById(R.id.txproveedor3);
        SQLiteDatabase bd = helperV.getReadableDatabase();

        try {
            helperV.getVenta(1);

            tvNombre1.setText(ventasDB.nombreV);
            tvref1.setText(ventasDB.refV);
            tvpago1.setText(ventasDB.pagoV);
            tvcantidad1.setText(ventasDB.cantidadV);
            tvcliente1.setText(ventasDB.clienteV);
            tvproveedor1.setText(ventasDB.proveedorV);

        } catch (Exception e){}
        try {
            helperV.getVenta(2);

            tvNombre2.setText(ventasDB.nombreV);
            tvref2.setText(ventasDB.refV);
            tvpago2.setText(ventasDB.pagoV);
            tvcantidad2.setText(ventasDB.cantidadV);
            tvcliente2.setText(ventasDB.clienteV);
            tvproveedor2.setText(ventasDB.proveedorV);

        } catch (Exception e){}

        try {
            helperV.getVenta(3);

            tvNombre3.setText(ventasDB.nombreV);
            tvref3.setText(ventasDB.refV);
            tvpago3.setText(ventasDB.pagoV);
            tvcantidad3.setText(ventasDB.cantidadV);
            tvcliente3.setText(ventasDB.clienteV);
            tvproveedor3.setText(ventasDB.proveedorV);

        }catch (Exception e){}
        bd.close();


    }

    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Ventas.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Ventas.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Ventas.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Ventas.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(Ventas.this, Catalogo.class);
        startActivity(intent);
    }
}
