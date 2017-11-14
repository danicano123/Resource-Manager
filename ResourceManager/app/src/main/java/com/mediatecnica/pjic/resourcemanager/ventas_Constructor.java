package com.mediatecnica.pjic.resourcemanager;

/**
 * Created by usuario on 13/11/2017.
 */

public class ventas_Constructor {
    int _id;
    String _nombre;
    String _ref;
    String _pago;
    String _cantidad;
    String _cliente;
    String _proveedor;

    // Constructor vacío
    public ventas_Constructor() {

    }

    // Constructor
    public ventas_Constructor(int id, String nombre, String ref, String pago, String cantidad, String cliente, String proveedor) {
        this._id = id;
        this._nombre = nombre;
        this._ref = ref;
        this._pago = pago;
        this._cantidad = cantidad;
        this._cliente = cliente;
        this._proveedor = proveedor;
    }
    public ventas_Constructor( String nombre, String ref, String pago, String cantidad, String cliente, String proveedor) {
        this._nombre = nombre;
        this._ref = ref;
        this._pago = pago;
        this._cantidad = cantidad;
        this._cliente = cliente;
        this._proveedor = proveedor;
    }

    public  int getID(){
        return this._id;
    }

    public  void setID(int id){
        this._id = id;
    }

    public String getNombre(){
        return this._nombre;
    }

    public void setNombre(String nombre){
        this._nombre = nombre;
    }

    public String getRef(){
        return this._ref;
    }

    public void setRef(String ref){
        this._ref = ref;
    }

    public String getPago(){
        return this._pago;
    }

    public void setPCompra(String pago){
        this._pago = pago;
    }

    public String getCantidad(){
        return this._cantidad;
    }

    public void setCantidad(String cantidad){
        this._cantidad = cantidad;
    }

    public String getCliente(){
        return this._cliente;
    }

    public void setCliente(String cliente){
        this._cliente = cliente;
    }

    public String getProovedor(){
        return this._proveedor;
    }

    public void setProovedor(String proveedor){
        this._nombre = proveedor;
    }
}
