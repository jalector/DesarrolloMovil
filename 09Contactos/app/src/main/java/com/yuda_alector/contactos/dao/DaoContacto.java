package com.yuda_alector.contactos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.yuda_alector.contactos.model.Contacto;
import com.yuda_alector.contactos.model.ContactoHeader;

import java.util.ArrayList;
import java.util.List;

public class DaoContacto {
    SQLiteDatabase databaseContext;
    Contacto contact;
    Context context;
    String database;
    String table;


    public DaoContacto(Context context){
        this.context = context;
        this.database = "Contactos";
        this.table = "create table if not exists contacto("+
                "id integer primary key autoincrement,nombre text,apellidoPaterno text,"+
                "apellidoMaterno text,telefono text,email text,calle text,colonia text, numero text,"+
                "ciudad text,estado text,estadoCivil text,enfermedades text,nacionalidad text,"+
                "numeroNomina text,curp text, puesto text)";

        this.databaseContext = context.openOrCreateDatabase(database, Context.MODE_PRIVATE, null);
        this.databaseContext.execSQL(table);
    }

    public ArrayList<ContactoHeader> getAllInstances() {
        Cursor cursor = this.databaseContext.rawQuery("select id, nombre, apellidoPaterno, puesto, email from contacto", null);
        ArrayList<ContactoHeader> contactos = new ArrayList<>();
        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                contactos.add(new ContactoHeader(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                ));
            }while (cursor.moveToNext());
        }
        return contactos;
    }

    public Contacto getContact(String id){
        Cursor cursor = this.databaseContext.rawQuery("select * from contacto where id = " + id, null);
        cursor.moveToFirst();
        Contacto contacto = new Contacto(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                cursor.getString(15),
                cursor.getString(16)
        );

        return contacto;
    }

    public boolean insert(Contacto contact){
        ContentValues content = new ContentValues();

        content.put("nombre", contact.getNombre());
        content.put("apellidoPaterno", contact.getApellidoPaterno());
        content.put("apellidoMaterno", contact.getApellidoMaterno());
        content.put("telefono", contact.getTelefono());
        content.put("email", contact.getEmail());

        content.put("calle", contact.getCalle());
        content.put("colonia", contact.getColonia());
        content.put("numero", contact.getNumero());

        content.put("ciudad", contact.getCiudad());
        content.put("estado", contact.getCiudad());
        content.put("estadoCivil", contact.getEstadoCivil());
        content.put("enfermedades", contact.getEnfermedades());
        content.put("nacionalidad", contact.getNacionalidad());
        content.put("numeroNomina", contact.getNumeroNomina());
        content.put("puesto", contact.getPuesto());
        content.put("curp", contact.getCurp());

        return (this.databaseContext.insert("contacto", null, content)) > 0 ;
    }

    public boolean edit(Contacto contact){
        ContentValues content = new ContentValues();

        content.put("nombre", contact.getNombre());
        content.put("apellidoPaterno", contact.getApellidoPaterno());
        content.put("apellidoMaterno", contact.getApellidoMaterno());
        content.put("telefono", contact.getTelefono());
        content.put("email", contact.getEmail());

        content.put("calle", contact.getCalle());
        content.put("colonia", contact.getColonia());
        content.put("numero", contact.getNumero());

        content.put("ciudad", contact.getCiudad());
        content.put("estado", contact.getCiudad());
        content.put("estadoCivil", contact.getEstadoCivil());
        content.put("enfermedades", contact.getEnfermedades());
        content.put("nacionalidad", contact.getNacionalidad());
        content.put("numeroNomina", contact.getNumeroNomina());
        content.put("puesto", contact.getPuesto());
        content.put("curp", contact.getCurp());

        return (this.databaseContext.update("contacto", content,"id="+ contact.getId(), null)) > 0 ;
    }




}
