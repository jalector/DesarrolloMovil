package com.yuda_alector.contactos.model;

import java.io.Serializable;

public class ContactoHeader implements Serializable {

    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String puesto;
    private String email;

    public ContactoHeader(String id, String nombre, String apellidoPaterno, String puesto, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.puesto = puesto;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return this.nombre + " " + this.apellidoPaterno + " | "+ this.email;
    }
}
