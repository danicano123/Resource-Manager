package com.mediatecnica.pjic.resourcemanager;

/**
 * Created by usuario on 04/11/2017.
 */

public class Clientes_Constructor {
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_identificacion() {
        return _identificacion;
    }

    public void set_identificacion(String _identificacion) {
        this._identificacion = _identificacion;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    public Clientes_Constructor(int _id, String _nombre, String _identificacion, String _telefono, String _correo) {
        this._id = _id;
        this._nombre = _nombre;
        this._identificacion = _identificacion;
        this._telefono = _telefono;
        this._correo = _correo;
    }
    public Clientes_Constructor( String _nombre, String _identificacion, String _telefono, String _correo) {
        this._nombre = _nombre;
        this._identificacion = _identificacion;
        this._telefono = _telefono;
        this._correo = _correo;
    }

    int _id;
    String _nombre;
    String _identificacion;
    String _telefono;
    String _correo;
}
