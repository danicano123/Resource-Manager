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
import android.widget.Toast;

public class inicio extends AppCompatActivity {
    final login_Helper helperL = new login_Helper(this);

    EditText textonombreL,textoclaveL;
    Button entrar;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        textonombreL = (EditText)findViewById(R.id.etUsuarioL);
        textoclaveL = (EditText)findViewById(R.id.etClaveL);

        entrar =(Button)findViewById(R.id.btnEntrar);
    }
    public void entrar(View v) {
        SQLiteDatabase bd = helperL.getReadableDatabase();
        String usuario = textonombreL.getText().toString();
        String contrasena = textoclaveL.getText().toString();
        try {
            helperL.getContacto(usuario);
            if (usuario.equals(login_Helper.name) && contrasena.equals(login_Helper.pass)) {
                Toast.makeText(getApplicationContext(), "Bienvenido " + usuario, Toast.LENGTH_LONG).show();
                bd.close();
                Intent intent = new Intent(inicio.this, Catalogo.class);
                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(), "Error de contraseña. Intentelo de nuevo!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "El usuario buscado no ha sido encontrado. Prueba registrarte!", Toast.LENGTH_SHORT).show();
        }
    }

    public void ir_registro(View v) {
        Intent intent = new Intent(inicio.this, registro.class);
        startActivity(intent);
    }
}

