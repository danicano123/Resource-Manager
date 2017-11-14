package com.mediatecnica.pjic.resourcemanager;



public class Articulos_Constructor {

    //Variables privadas
    int _id;
    String _nombre;
    String _ref;
    String _precioCompra;
    String _precioVenta;
    String _cantidad;
    String _proveedor;

    // Constructor vacío
    public Articulos_Constructor() {

    }

    // Constructor
    public Articulos_Constructor(int id, String nombre, String ref, String precioCompra, String precioVenta, String cantidad, String proveedor) {
        this._id = id;
        this._nombre = nombre;
        this._ref = ref;
        this._precioCompra = precioCompra;
        this._precioVenta = precioVenta;
        this._cantidad = cantidad;
        this._proveedor = proveedor;
    }
    public Articulos_Constructor( String nombre, String ref, String precioCompra, String precioVenta, String cantidad, String proveedor) {
        this._nombre = nombre;
        this._ref = ref;
        this._precioCompra = precioCompra;
        this._precioVenta = precioVenta;
        this._cantidad = cantidad;
        this._proveedor = proveedor;
    }

    public  int get_id(){return this._id;}

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

    public String getPCompra(){
        return this._precioCompra;
    }

    public void setPCompra(String precioCompra){
        this._nombre = precioCompra;
    }

    public String getPVenta(){
        return this._precioVenta;
    }

    public void setPVenta(String precioVenta){
        this._nombre = precioVenta;
    }

    public String getCantidad(){
        return this._cantidad;
    }

    public void setCantidad(String cantidad){
        this._nombre = cantidad;
    }

    public String getProovedor(){
        return this._proveedor;
    }

    public void setProovedor(String proveedor){
        this._nombre = proveedor;
    }


}