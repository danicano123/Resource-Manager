package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Clientes extends AppCompatActivity {
    final clientesDB helperC = new clientesDB(this);
    TextView tvNombre1, tvcedula1, tvtel1, tvcorreo1,
            tvNombre2, tvcedula2, tvtel2, tvcorreo2,
    tvNombre3, tvcedula3, tvtel3, tvcorreo3;

    public static int ayuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        tvNombre1 = (TextView) findViewById(R.id.textnombre1);
        tvNombre2 = (TextView) findViewById(R.id.textnombre2);
        tvNombre3 = (TextView) findViewById(R.id.textnombre3);
        tvcedula1 = (TextView) findViewById(R.id.textcedula1);
        tvcedula2 = (TextView) findViewById(R.id.textcedula2);
        tvcedula3 = (TextView) findViewById(R.id.textcedula3);
        tvtel1 = (TextView) findViewById(R.id.texttelefono1);
        tvtel2 = (TextView) findViewById(R.id.texttelefono2);
        tvtel3 = (TextView) findViewById(R.id.texttelefono3);
        tvcorreo1 = (TextView) findViewById(R.id.textcorreo1);
        tvcorreo2 = (TextView) findViewById(R.id.textcorreo2);
        tvcorreo3 = (TextView) findViewById(R.id.textcorreo3);

        SQLiteDatabase bd = helperC.getReadableDatabase();

        try {
            helperC.getClientes(1);

            tvNombre1.setText(clientesDB.nombreC);
            tvcedula1.setText(clientesDB.identificacionC);
            tvtel1.setText(clientesDB.telefonoC);
            tvcorreo1.setText(clientesDB.correoC);

        } catch (Exception e){}
        try {
            helperC.getClientes(2);

            tvNombre2.setText(clientesDB.nombreC);
            tvcedula2.setText(clientesDB.identificacionC);
            tvtel2.setText(clientesDB.telefonoC);
            tvcorreo2.setText(clientesDB.correoC);

        } catch (Exception e){}

        try {
            helperC.getClientes(3);

            tvNombre3.setText(clientesDB.nombreC);
            tvcedula3.setText(clientesDB.identificacionC);
            tvtel3.setText(clientesDB.telefonoC);
            tvcorreo3.setText(clientesDB.correoC);

        }catch (Exception e){}
        bd.close();

    }




    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Clientes.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Clientes.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Clientes.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Clientes.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(Clientes.this, Catalogo.class);
        startActivity(intent);
    }

    public void act1 (View v){
        ayuda = 1;
        Intent intent = new Intent(Clientes.this, actualizar_cliente.class);
        startActivity(intent);
    }
    public void act2 (View v){
        ayuda = 2;
        Intent intent = new Intent(Clientes.this, actualizar_cliente.class);
        startActivity(intent);
    }
    public void act3 (View v){
        ayuda = 3;
        Intent intent = new Intent(Clientes.this, actualizar_cliente.class);
        startActivity(intent);
    }
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(Clientes.this, Clientes.class);
        startActivity(intent);
    }*/
}
