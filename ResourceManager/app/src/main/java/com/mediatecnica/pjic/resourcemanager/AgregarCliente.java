package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarCliente extends AppCompatActivity {
    final clientesDB helperC = new clientesDB(this);

    Button butonInsertar;
    EditText textonombre, textoidentificacion, textocorreo, textotelefono;

    String nombre;
    String identificacion;
    String telefono;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);

        textonombre = (EditText)findViewById(R.id.edname);
        textoidentificacion = (EditText)findViewById(R.id.identificacion);
        textotelefono = (EditText)findViewById(R.id.telefono);
        textocorreo = (EditText)findViewById(R.id.correo);

        butonInsertar = (Button)findViewById(R.id.insert_button);
    }
    public void ir_añadir_p(View v) {
        Intent intent = new Intent(AgregarCliente.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(AgregarCliente.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(AgregarCliente.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(AgregarCliente.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(AgregarCliente.this, Catalogo.class);
        startActivity(intent);
    }
    public void insertCliente(View v){

        nombre = textonombre.getText().toString();
        identificacion = textoidentificacion.getText().toString();
        telefono = textotelefono.getText().toString();
        correo = textocorreo.getText().toString();

        helperC.addCliente(new Clientes_Constructor(nombre,identificacion,telefono,correo));
        Toast.makeText(getApplicationContext(), "El cliente "+nombre+" ha sido registrado con éxito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AgregarCliente.this, Clientes.class);
        startActivity(intent);
    }
    }
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(AgregarCliente.this, Clientes.class);
        startActivity(intent);
    }*/

