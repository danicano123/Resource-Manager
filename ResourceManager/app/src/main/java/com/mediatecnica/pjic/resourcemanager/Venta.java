package com.mediatecnica.pjic.resourcemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Venta extends AppCompatActivity {
    final clientesDB helperC = new clientesDB(this);
    final DB_Helper helperA = new DB_Helper(this);
    final ventasDB helperV = new ventasDB(this);
    TextView cantidad,pagoT;
    int cont=0,aPagar;
    String total;
    String canti;
    String Nombre;
    String ref;
    String pago;
    String Cantidad;
    String cliente;
    String proveedor;
    int comparacion ;
    EditText ConfirmaNombre;
    TextView cant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);
        cantidad = (TextView) findViewById(R.id.TVcantidad);
        pagoT = (TextView) findViewById(R.id.pagoTotal) ;
        cantidad.setText(Integer.toString(cont));

        ConfirmaNombre = (EditText)findViewById(R.id.ConfirmNombre);
        cant = (TextView) findViewById(R.id.TVcantidad);
    }
    public void sumar(View v) {

        cont = cont + 1;
        cantidad.setText(Integer.toString(cont));
        canti = cant.getText().toString();
        aPagar = Integer.parseInt(canti) * Integer.parseInt(DB_Helper.pVentaA);
        pagoT.setText(Integer.toString(aPagar));
    }
    public void restar(View v) {
        if(cont ==0){
            canti = cant.getText().toString();
            aPagar = Integer.parseInt(canti) * Integer.parseInt(DB_Helper.pVentaA);
            pagoT.setText(Integer.toString(aPagar));

        }
        else{
        cont = cont - 1;
        cantidad.setText(Integer.toString(cont));
            canti = cant.getText().toString();
            aPagar = Integer.parseInt(canti) * Integer.parseInt(DB_Helper.pVentaA);
            pagoT.setText(Integer.toString(aPagar));
        }
    }

    public void ir_añadir_p(View v) {
        Intent intent = new Intent(Venta.this, Agregar_producto.class);
        startActivity(intent);
    }
    public void ir_agregar_c(View v) {
        Intent intent = new Intent(Venta.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void ir_clientes(View v) {
        Intent intent = new Intent(Venta.this, Clientes.class);
        startActivity(intent);
    }
    public void ir_ventas(View v) {
        Intent intent = new Intent(Venta.this, Ventas.class);
        startActivity(intent);
    }
    public void ir_catalogo(View v) {
        Intent intent = new Intent(Venta.this, Catalogo.class);
        startActivity(intent);
    }

    public void vender (View v) {
        SQLiteDatabase bd = helperC.getReadableDatabase();
        SQLiteDatabase db = helperA.getReadableDatabase();
        try {

            helperC.getClientesV(ConfirmaNombre.getText().toString());
            try {
                helperA.getArticulo(Catalogo.ayuda);
                comparacion = Integer.parseInt(DB_Helper.cantidadA);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El usuario " + ConfirmaNombre + " no a sido encontrado", Toast.LENGTH_SHORT).show();
        }

        bd.close();
        db.close();

        helperC.getWritableDatabase();
        helperA.getWritableDatabase();

        if (Integer.parseInt(canti) < Integer.parseInt(DB_Helper.cantidadA)) {
            helperV.addVenta(new ventas_Constructor(DB_Helper.nombreA, DB_Helper.refA, Integer.toString(aPagar), canti, ConfirmaNombre.getText().toString(), DB_Helper.proveedorA));
            Toast.makeText(getApplicationContext(), "El articulo "+DB_Helper.nombreA+" ha sido vendido con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Venta.this, Ventas.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(getApplicationContext(), "La cantidad deseada excede la cantidad del producto. !Prueba con otra cantidad!", Toast.LENGTH_SHORT).show();
        }


    }


}
   /* public void ir_movimiento(View v) {
        Intent intent = new Intent(catalogo.this, Clientes.class);
        startActivity(intent);
    }*/





