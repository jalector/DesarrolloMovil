package com.yuda_alector.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yuda_alector.contactos.dao.DaoContacto;
import com.yuda_alector.contactos.model.Contacto;

public class NewContact extends AppCompatActivity {

    TextView nombre,
            apellidoPaterno,
            apellidoMaterno,
            telefono,
            email,
            calle,
            colonia,
            numero,
            ciudad,
            estado,
            estadoCivil,
            enfermedades,
            nacionalidad,
            numeroNomina,
            curp,
            puesto;

    DaoContacto crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        this.crud = new DaoContacto(NewContact.this);

        this.nombre = this.findViewById(R.id.tv_nombre);
        this.apellidoPaterno = this.findViewById(R.id.tv_apellido_paterno);
        this.apellidoMaterno = this.findViewById(R.id.tv_apellido_materno);
        this.telefono = this.findViewById(R.id.tv_telefono);
        this.email = this.findViewById(R.id.tv_email);
        this.calle = this.findViewById(R.id.tv_calle);
        this.colonia = this.findViewById(R.id.tv_colonia);
        this.numero = this.findViewById(R.id.tv_numero);
        this.ciudad = this.findViewById(R.id.tv_ciudad);
        this.estado = this.findViewById(R.id.tv_estado);
        this.estadoCivil = this.findViewById(R.id.tv_estado_civil);
        this.enfermedades = this.findViewById(R.id.tv_enfermedades);
        this.nacionalidad = this.findViewById(R.id.tv_nacionalidad);
        this.numeroNomina = this.findViewById(R.id.tv_numero_nomina);
        this.curp = this.findViewById(R.id.tv_cupr);
        this.puesto = this.findViewById(R.id.tv_puesto);
    }

    public void save(View view) {
        Contacto contact = this.getContact();
        if(this.crud.insert(contact)){
            Toast.makeText(this, "Contacto "+ contact.getNombre()+" añadido con éxito", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, "Tenemos problemas par añadir a "+ contact.getNombre() , Toast.LENGTH_SHORT).show();
        }

    }

    public Contacto getContact(){
        return new Contacto(
                null,
                nombre.getText().toString(),
                apellidoPaterno.getText().toString(),
                apellidoMaterno.getText().toString(),
                telefono.getText().toString(),
                email.getText().toString(),
                calle.getText().toString(),
                colonia.getText().toString(),
                numero.getText().toString(),
                ciudad.getText().toString(),
                estado.getText().toString(),
                estadoCivil.getText().toString(),
                enfermedades.getText().toString(),
                nacionalidad.getText().toString(),
                numeroNomina.getText().toString(),
                curp.getText().toString(),
                puesto.getText().toString()
        );
    }
}
