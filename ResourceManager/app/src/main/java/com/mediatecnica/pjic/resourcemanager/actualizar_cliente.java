package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class actualizar_cliente extends AppCompatActivity {
    clientesDB helperC = new clientesDB(this);

    EditText txtnombre, txtid, txttel,txtcorreo;

    private String nombre;
    private String id;
    String tel;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_cliente);

        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtid = (EditText)findViewById(R.id.txtid);
        txttel = (EditText)findViewById(R.id.txttelefono);
        txtcorreo = (EditText)findViewById(R.id.txtcorreo);

        SQLiteDatabase bd = helperC.getReadableDatabase();

        try {
            helperC.getClientes(1);

            txtnombre.setText(clientesDB.nombreC);
            txtid.setText(clientesDB.identificacionC);
            txttel.setText(clientesDB.telefonoC);
            txtcorreo.setText(clientesDB.correoC);

        } catch (Exception e){}
        try {
            helperC.getClientes(2);

            txtnombre.setText(clientesDB.nombreC);
            txtid.setText(clientesDB.identificacionC);
            txttel.setText(clientesDB.telefonoC);
            txtcorreo.setText(clientesDB.correoC);
        } catch (Exception e){}

        try {
            helperC.getClientes(3);

            txtnombre.setText(clientesDB.nombreC);
            txtid.setText(clientesDB.identificacionC);
            txttel.setText(clientesDB.telefonoC);
            txtcorreo.setText(clientesDB.correoC);

        }catch (Exception e){}
        bd.close();


    }
    public void ir_añadir_p(View v) {
        Intent intent = new Intent(actualizar_cliente.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(actualizar_cliente.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(actualizar_cliente.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(actualizar_cliente.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(actualizar_cliente.this, Catalogo.class);
        startActivity(intent);
    }

    public  void ActC (View v){

        nombre = txtnombre.getText().toString();
        id = txtid.getText().toString();
        tel = txttel.getText().toString();
        correo = txtcorreo.getText().toString();

        helperC.udDateCliente(new Clientes_Constructor(nombre,id,tel,correo));
        Intent intent = new Intent(actualizar_cliente.this, Clientes.class);
        startActivity(intent);
    }
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(actualizar_cliente.this, Clientes.class);
        startActivity(intent);
    }*/



}
