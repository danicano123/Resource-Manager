package com.mediatecnica.pjic.resourcemanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    EditText edNombre;
    EditText edClave;
    EditText edConfirm;

    String nombre;
    String clave;
    String Confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edNombre = (EditText) findViewById(R.id.etUsuario);
        edClave = (EditText) findViewById(R.id.etClave);
        edConfirm = (EditText) findViewById(R.id.etclaveConfirm);
    }

    public void btnRegistrar (View v){
        nombre = edNombre.getText().toString();
        clave = edClave.getText().toString();
        Confirmar = edConfirm.getText().toString();

        //Abrir base de datos
        login_Helper helperL = new login_Helper(this);
        if (clave.equals(Confirmar)) {
            // Insertar contactos
            helperL.addContacto(new Contacto(nombre, clave));
            Toast.makeText(getApplicationContext(), "El usuario "+nombre+" ha sido guardado con éxito", Toast.LENGTH_SHORT).show();

            //Volver a pantalla principal
            Intent intent = new Intent(registro.this, inicio.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden. Compruebalas!", Toast.LENGTH_SHORT).show();
    }
    }




