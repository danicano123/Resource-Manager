package com.mediatecnica.pjic.resourcemanager;



public class Contacto {

    //Variables privadas
    int _id;
    String _nombre;
    String _clave;

    // Constructor vacío
    public Contacto(){

    }
    // Constructor
    public Contacto(int id, String nombre, String clave){
        this._id = id;
        this._nombre = nombre;
        this._clave = clave;
    }

    // Constructor
    public Contacto(String nombre, String clave){
        this._nombre = nombre;
        this._clave = clave;
    }

    // --------------- MÉTDOS GET Y SET ---------------
    // obtener ID
    public int getID(){
        return this._id;
    }

    // poner id
    public void setID(int id){
        this._id = id;
    }

    // obtener nombre
    public String getNombre(){
        return this._nombre;
    }

    // poner nombre
    public void setNombre(String nombre){
        this._nombre = nombre;
    }

    // obtener teléfono
    public String getClave(){
        return this._clave;
    }

    // poner teléfono
    public void setClave(String clave){
        this._clave = clave;
    }
}